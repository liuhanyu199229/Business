package com.formssi.third.dao;

import com.formssi.third.dto.SubcontractorsInfoDto;
import com.formssi.third.model.SubcontractorsInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcontractorsInfoDao {
    int insertBatch(List<SubcontractorsInfo> projectList);
    List<SubcontractorsInfo> getListByPage(@Param("form") SubcontractorsInfoDto subcontractorsInfoDto);
}
