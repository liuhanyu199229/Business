package com.formssi.third.dao;

import com.formssi.third.dto.AdminExcelModel;
import com.formssi.third.dto.UmsAdminDto2;
import com.formssi.third.dto.UmsAdminVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface UmsAdminDao {
    List<UmsAdminVo> getAdminList(@Param("form") UmsAdminDto2 dto);
    List<AdminExcelModel> getAdminList2(@Param("form") UmsAdminDto2 dto);
}
