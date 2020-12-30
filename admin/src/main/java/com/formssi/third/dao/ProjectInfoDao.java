package com.formssi.third.dao;

import com.formssi.third.dto.ProjectInfoDto;
import com.formssi.third.model.ProjectInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectInfoDao {
    int insertBatch(List<ProjectInfo> projectList);
    List<ProjectInfo> getListByPage(@Param("form") ProjectInfoDto projectInfoDto);
}
