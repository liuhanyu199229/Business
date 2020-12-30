package com.formssi.third.mapper;

import com.formssi.third.model.UmsAdminLogs;
import com.formssi.third.model.UmsAdminLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2020/09/18
*/
public interface UmsAdminLogsMapper {
    long countByExample(UmsAdminLogsExample example);

    int deleteByExample(UmsAdminLogsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsAdminLogs record);

    int insertSelective(UmsAdminLogs record);

    List<UmsAdminLogs> selectByExample(UmsAdminLogsExample example);

    UmsAdminLogs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsAdminLogs record, @Param("example") UmsAdminLogsExample example);

    int updateByExample(@Param("record") UmsAdminLogs record, @Param("example") UmsAdminLogsExample example);

    int updateByPrimaryKeySelective(UmsAdminLogs record);

    int updateByPrimaryKey(UmsAdminLogs record);
}