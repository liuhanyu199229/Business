package com.formssi.third.service;

import com.formssi.third.dto.ProjectInfoDto;
import com.formssi.third.dto.ProjectInfoVo;
import com.formssi.third.model.ProjectInfo;
import com.formssi.third.model.ProjectInfoExample;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProjectInfoService {
    int insertSelective(ProjectInfo info);
    int updateByPrimaryKeySelective(ProjectInfo info);
    int deleteByPrimaryKey(Integer id);
    List<ProjectInfo> selectByExample(ProjectInfoExample example);
    List<ProjectInfo> selectAll();
    List<ProjectInfo> getListByPage(ProjectInfoDto projectInfoDto);
    ProjectInfo selectByPrimaryKey(Integer id);
    /**
     * 批量导入excel
     * @param file
     * @return
     */
    ProjectInfoVo importExcel(MultipartFile file);
    /**
     * 批量导入excel
     * @param list
     * @return
     */
    Map<String, Integer> deleteByList(List<Integer> list);
}
