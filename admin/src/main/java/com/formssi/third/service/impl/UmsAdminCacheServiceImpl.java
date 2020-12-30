package com.formssi.third.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.formssi.third.common.constants.RedisKeyConstant;
import com.formssi.third.dao.UmsAdminRoleRelationDao;
import com.formssi.third.dto.UmsAdminVo;
import com.formssi.third.mapper.UmsAdminRoleRelationMapper;
import com.formssi.third.model.UmsAdmin;
import com.formssi.third.model.UmsAdminRoleRelation;
import com.formssi.third.model.UmsAdminRoleRelationExample;
import com.formssi.third.model.UmsResource;
import com.formssi.third.security.service.RedisService;
import com.formssi.third.service.UmsAdminCacheService;
import com.formssi.third.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UmsAdminCacheService实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Override
    public void delAdmin(Long adminId) {
        UmsAdminVo admin = adminService.getItem(adminId);
        if (admin != null) {
            String key = RedisKeyConstant.FORMSSI_BASE_USER + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = RedisKeyConstant.FORMSSI_BASE_USER_RESOURCE + adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            List<String> keys = relationList.stream().map(relation -> RedisKeyConstant.FORMSSI_BASE_USER_RESOURCE + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = RedisKeyConstant.FORMSSI_BASE_USER_RESOURCE;
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> adminIdList = adminRoleRelationDao.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminIdList)) {
            List<String> keys = adminIdList.stream().map(adminId -> RedisKeyConstant.FORMSSI_BASE_USER_RESOURCE + adminId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = RedisKeyConstant.FORMSSI_BASE_USER + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = RedisKeyConstant.FORMSSI_BASE_USER + admin.getUsername();
        redisService.set(key, admin, RedisKeyConstant.EXPIRATION_TIME_1_WEEK);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = RedisKeyConstant.FORMSSI_BASE_USER_RESOURCE + adminId;
        return (List<UmsResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = RedisKeyConstant.FORMSSI_BASE_USER_RESOURCE + adminId;
        redisService.set(key, resourceList, RedisKeyConstant.EXPIRATION_TIME_1_WEEK);
    }
}
