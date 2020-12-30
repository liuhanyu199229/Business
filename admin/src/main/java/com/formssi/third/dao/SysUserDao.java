package com.formssi.third.dao;

import com.formssi.third.dto.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人员信息自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface SysUserDao {
    List<SysUserVo> getUserList(@Param("name") String name);
}
