package com.formssi.third.mapper;

import com.formssi.third.model.SubcontractorsInfo;
import com.formssi.third.model.SubcontractorsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator on 2020/09/12
*/
public interface SubcontractorsInfoMapper {
    long countByExample(SubcontractorsInfoExample example);

    int deleteByExample(SubcontractorsInfoExample example);

    int deleteByPrimaryKey(Integer subcontractorsId);

    int insert(SubcontractorsInfo record);

    int insertSelective(SubcontractorsInfo record);

    List<SubcontractorsInfo> selectByExample(SubcontractorsInfoExample example);

    SubcontractorsInfo selectByPrimaryKey(Integer subcontractorsId);

    int updateByExampleSelective(@Param("record") SubcontractorsInfo record, @Param("example") SubcontractorsInfoExample example);

    int updateByExample(@Param("record") SubcontractorsInfo record, @Param("example") SubcontractorsInfoExample example);

    int updateByPrimaryKeySelective(SubcontractorsInfo record);

    int updateByPrimaryKey(SubcontractorsInfo record);
}