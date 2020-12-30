package com.formssi.third.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.formssi.third.bo.AdminUserDetails;
import com.formssi.third.common.api.CommonResult;
import com.formssi.third.common.api.ResultCode;
import com.formssi.third.common.constants.RedisKeyConstant;
import com.formssi.third.common.enums.AccountStatusEnum;
import com.formssi.third.common.enums.IsDeleteEnum;
import com.formssi.third.common.enums.RoleStatusEnum;
import com.formssi.third.common.exception.ApiException;
import com.formssi.third.dao.UmsAdminDao;
import com.formssi.third.dao.UmsAdminPermissionRelationDao;
import com.formssi.third.dao.UmsAdminRoleRelationDao;
import com.formssi.third.dto.*;
import com.formssi.third.mapper.*;
import com.formssi.third.model.*;
import com.formssi.third.security.service.RedisService;
import com.formssi.third.security.util.JwtTokenUtil;
import com.formssi.third.service.UmsAdminService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UmsAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Slf4j
@Service
@Transactional
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Resource
    private UmsAdminMapper adminMapper;
    @Resource
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Resource
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Resource
    private UmsAdminPermissionRelationMapper adminPermissionRelationMapper;
    @Resource
    private UmsAdminPermissionRelationDao adminPermissionRelationDao;
    @Resource
    private UmsAdminLoginLogMapper loginLogMapper;
    @Resource
    private UmsAdminDao umsAdminDao;
    @Resource
    private UmsRoleMapper umsRoleMapper;
    @Resource
    private BmsBusinessMapper bmsBusinessMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private RedisService redisService;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username).andStatusEqualTo(AccountStatusEnum.ENABLE.getCode()).andIsDeleteEqualTo(IsDeleteEnum.FALSE.getCode());
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            UmsAdmin admin = adminList.get(0);
            return admin;
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam){
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());

        //查询是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername()).andIsDeleteEqualTo(IsDeleteEnum.FALSE.getCode());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            throw new ApiException(ResultCode.ACCOUNT_EXIST);
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getMobile());
        umsAdmin.setPassword(encodePassword);
        umsAdmin.setIsDelete(IsDeleteEnum.FALSE.getCode());
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new ApiException(ResultCode.PASSWORD_ERROR);
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            log.error("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     *
     * 验证账号是否可以正常登陆
     * 账号可能被禁用，可能被删除，
     * 账号可能未关联角色，所关联的角色也可能被禁用
     */
    private UmsAdmin checkAccount(String username){
        //获取用户信息
        boolean bool = false;
        UmsAdmin admin = getAdminByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("用户名或密码错误或账号已被删除|禁用");
        }
        //查询角色
        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andAdminIdEqualTo(admin.getId());
        List<UmsAdminRoleRelation> list = adminRoleRelationMapper.selectByExample(example);
        //没有分配角色，提示异常
        if(CollectionUtils.isEmpty(list)){
            throw new ApiException(ResultCode.ACCOUNT_NOT_ROLE);
        }else{
            //已经分配角色，但是角色被禁用的情况下 提示
            for(UmsAdminRoleRelation adminRole:list){
                UmsRoleExample roleExample = new UmsRoleExample();
                roleExample.createCriteria().andIdEqualTo(adminRole.getRoleId()).andStatusEqualTo(RoleStatusEnum.ENABLE.getCode());
                List<UmsRole> umsRoleList = umsRoleMapper.selectByExample(roleExample);
                if(!CollectionUtils.isEmpty(umsRoleList)){
                    bool = true;
                }
            }
        }
        if(!bool){
            throw new ApiException(ResultCode.ACCOUNT_EXCEPTION);
        }
        return admin;
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if(admin==null) {
            return;
        }
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     */
    private void updateLoginTimeByUsername(String username) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
    }

    @Override
    public String refreshToken(String oldToken) {
        String token = jwtTokenUtil.refreshHeadToken(oldToken);
        return token;
    }

    @Override
    public UmsAdminVo getItem(Long id) {
        UmsAdminVo umsAdminVo = new UmsAdminVo();
        UmsAdmin admin = adminMapper.selectByPrimaryKey(id);
        if(admin!=null){
            BeanUtils.copyProperties(admin,umsAdminVo);
            if(null!=admin.getBusinessId()){
                BmsBusiness business = bmsBusinessMapper.selectByPrimaryKey(admin.getBusinessId());
                umsAdminVo.setBusinessName(business.getBusinessName());
                StringBuffer address = new StringBuffer();
                address.append(business.getProvinceName()).append(business.getCityName())
                        .append(business.getDistrictName()).append(business.getDetailAddress());
                umsAdminVo.setBusinessAddress(address.toString());
                umsAdminVo.setBusinessDescription(business.getDescription());
            }
        }
        return umsAdminVo;
    }

    @Override
    public List<UmsAdminVo> list(UmsAdminDto2 dto) {
        //Page<UmsAdminVo> adminPageList = new Page<UmsAdminVo>();
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return umsAdminDao.getAdminList(dto);
    }

    @Override
    public List<AdminExcelModel> list2(UmsAdminDto2 dto) {
        return umsAdminDao.getAdminList2(dto);
    }

    @Override
    public int update(UmsAdmin admin) {
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        return count;
    }

    @Override
    public int updateBatch(List<Long> list, UmsAdmin admin) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andIdIn(list);
        int count = adminMapper.updateByExampleSelective(admin,example);
        return list.size();
    }

    @Override
    public int delete(Long id) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setId(id);
        umsAdmin.setIsDelete(IsDeleteEnum.TRUE.getCode());
        int count = adminMapper.updateByPrimaryKeySelective(umsAdmin);
        return count;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = adminRoleRelationDao.getResourceList(adminId);
        return resourceList;
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        //删除原所有权限关系
        UmsAdminPermissionRelationExample relationExample = new UmsAdminPermissionRelationExample();
        relationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminPermissionRelationMapper.deleteByExample(relationExample);
        //获取用户所有角色权限
        List<UmsPermission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
        List<Long> rolePermissionList = permissionList.stream().map(UmsPermission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<UmsAdminPermissionRelation> relationList = new ArrayList<>();
            //筛选出+权限
            List<Long> addPermissionIdList = permissionIds.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //筛选出-权限
            List<Long> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //插入+-权限关系
            relationList.addAll(convert(adminId,1,addPermissionIdList));
            relationList.addAll(convert(adminId,-1,subPermissionIdList));
            return adminPermissionRelationDao.insertList(relationList);
        }
        return 0;
    }

    /**
     * 将+-权限关系转化为对象
     */
    private List<UmsAdminPermissionRelation> convert(Long adminId,Integer type,List<Long> permissionIdList) {
        List<UmsAdminPermissionRelation> relationList = permissionIdList.stream().map(permissionId -> {
            UmsAdminPermissionRelation relation = new UmsAdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
        return relationList;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam param) {
        if(StrUtil.isEmpty(param.getUsername())
                ||StrUtil.isEmpty(param.getOldPassword())
                ||StrUtil.isEmpty(param.getNewPassword())){
            throw new ApiException(ResultCode.PARAM_MISSING);
        }
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(param.getUsername()).andIsDeleteEqualTo(IsDeleteEnum.FALSE.getCode());
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if(CollUtil.isEmpty(adminList)){
            throw new ApiException(ResultCode.USER_NOT_EXIST);
        }
        UmsAdmin umsAdmin = adminList.get(0);
        if(!passwordEncoder.matches(param.getOldPassword(),umsAdmin.getPassword())){
            throw new ApiException(ResultCode.OLD_PASSWORD_ERROR);
        }
        umsAdmin.setPassword(passwordEncoder.encode(param.getNewPassword()));

        return adminMapper.updateByPrimaryKey(umsAdmin);
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        UmsAdmin admin = checkAccount(username);
        List<UmsResource> resourceList = getResourceList(admin.getId());
        return new AdminUserDetails(admin,resourceList);
    }

    @Override
    public int resetPassword(Long id) {
        UmsAdmin umsAdmin = adminMapper.selectByPrimaryKey(id);
        if(umsAdmin==null) {
            throw new ApiException(ResultCode.USER_NOT_EXIST);
        }
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getMobile()));
        return adminMapper.updateByPrimaryKeySelective(umsAdmin);
    }

    /**
     * 登出，清除用户基本信息缓存,菜单权限缓存和token缓存
     * @param umsAdmin
     */
    @Override
    public void logout(UmsAdmin umsAdmin) {

    }
}
