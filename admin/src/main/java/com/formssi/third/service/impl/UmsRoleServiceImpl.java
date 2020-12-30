package com.formssi.third.service.impl;

import com.formssi.third.common.api.ResultCode;
import com.formssi.third.common.exception.ApiException;
import com.formssi.third.dao.UmsRoleDao;
import com.formssi.third.dao.UmsRolePermissionRelationDao;
import com.formssi.third.mapper.*;
import com.formssi.third.model.*;
import com.formssi.third.service.UmsAdminCacheService;
import com.formssi.third.service.UmsRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 后台角色管理Service实现类
 * Created by macro on 2018/9/30.
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Resource
    private UmsRoleMapper roleMapper;
    @Resource
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;
    @Resource
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Resource
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Resource
    private UmsRolePermissionRelationDao rolePermissionRelationDao;
    @Resource
    private UmsRoleDao roleDao;

    @Resource
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Override
    public int create(UmsRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(Long id) {
        UmsRole role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new ApiException(ResultCode.ROLE_NOT_EXIST);
        }
        //先判断角色下面是否已经关联了账号，如果关联了不能直接删除
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andRoleIdEqualTo(id);
        List<UmsAdminRoleRelation> adminRoleList = adminRoleRelationMapper.selectByExample(adminRoleRelationExample);
        if(!CollectionUtils.isEmpty(adminRoleList)){
            throw new ApiException(ResultCode.ROLE_DELETE_FAIL);
        }
        //删除角色和菜单的关系
        UmsRoleMenuRelationExample roleMenuRelationExample=new UmsRoleMenuRelationExample();
        roleMenuRelationExample.createCriteria().andRoleIdEqualTo(id);
        roleMenuRelationMapper.deleteByExample(roleMenuRelationExample);

        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdEqualTo(id);
        int count = roleMapper.deleteByExample(example);

        List<Long> roleIds = new ArrayList<>();
        roleIds.add(id);
        return count;
    }
    @Override
    public int deleteByList(List<Long> list) {
        //先判断角色下面是否已经关联了账号，如果关联了不能直接删除
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andRoleIdIn(list);
        List<UmsAdminRoleRelation> adminRoleList = adminRoleRelationMapper.selectByExample(adminRoleRelationExample);
        if(!CollectionUtils.isEmpty(adminRoleList)){
            throw new ApiException(ResultCode.ROLE_DELETE_FAIL);
        }
        //删除角色和菜单的关系
        UmsRoleMenuRelationExample roleMenuRelationExample=new UmsRoleMenuRelationExample();
        roleMenuRelationExample.createCriteria().andRoleIdIn(list);
        roleMenuRelationMapper.deleteByExample(roleMenuRelationExample);

        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdIn(list);
        int count = roleMapper.deleteByExample(example);

        return count;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long roleId) {
        return rolePermissionRelationDao.getPermissionList(roleId);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        UmsRolePermissionRelationExample example=new UmsRolePermissionRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(example);
        //批量插入新关系
        List<UmsRolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            UmsRolePermissionRelation relation = new UmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return rolePermissionRelationDao.insertList(relationList);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsRoleExample example = new UmsRoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsMenuTree> getMenuTree(Long adminId) {
        List<UmsMenuTree> list = roleDao.getMenuTree(adminId);
        List<UmsMenuTree> menuList  = new ArrayList<>();
        menuList = list.stream().filter(UmsMenu -> Objects.equals(UmsMenu.getLevel(),0)).collect(Collectors.toList());
        // 先找到所有的一级菜单
//        for (int i = 0; i < list.size(); i++) {
//            // 一级菜单没有parentId
//            if (list.get(i).getParentId()==0L) {
//                // 一级菜单没有parentId
//                menuList.add(list.get(i));
//
//            }
//        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (UmsMenuTree menu : menuList) {
            Meta meta = new Meta();
            meta.setTitle(menu.getTitle());
            meta.setIcon(menu.getIcon());
            menu.setMeta(meta);
            menu.setChildren(getChild(menu.getId(), list));
        }
        return menuList;
    }

    @Override
    public List<UmsMenuTree> getChild(Long adminId, List<UmsMenuTree> menuList) {
        // 子菜单
        List<UmsMenuTree> childList = new ArrayList<>();
        for (UmsMenuTree menu : menuList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId()>0) {
                if (menu.getParentId() == adminId) {
                    Meta meta = new Meta();
                    meta.setTitle(menu.getTitle());
                    meta.setIcon(menu.getIcon());
                    menu.setMeta(meta);
                    menu.setChildren(getChild(menu.getId(), childList));
                    childList.add(menu);
                }
            }
        }

        return childList;
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return roleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return roleDao.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        UmsRoleMenuRelationExample example=new UmsRoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();

    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        UmsRoleResourceRelationExample example=new UmsRoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        return resourceIds.size();
    }
}
