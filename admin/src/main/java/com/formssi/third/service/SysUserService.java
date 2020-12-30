package com.formssi.third.service;

import com.formssi.third.common.exception.ApiException;
import com.formssi.third.dto.*;
import com.formssi.third.model.UmsAdmin;
import com.formssi.third.model.UmsPermission;
import com.formssi.third.model.UmsResource;
import com.formssi.third.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 人员Service
 * Created by macro on 2018/4/26.
 */
public interface SysUserService {
    /**
     * 获取后台人员信息
     */
    List<SysUserVo> getSysUser(String username);

}
