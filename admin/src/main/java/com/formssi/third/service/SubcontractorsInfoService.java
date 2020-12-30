package com.formssi.third.service;

import com.formssi.third.dto.SubcontractorsInfoDto;
import com.formssi.third.dto.SubcontractorsInfoVo;
import com.formssi.third.model.SubcontractorsInfo;
import com.formssi.third.model.SubcontractorsInfoExample;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

public interface SubcontractorsInfoService {
    int insertSelective(SubcontractorsInfo info);
    int updateByPrimaryKeySelective(SubcontractorsInfo info);
    int deleteByPrimaryKey(Integer id);
    List<SubcontractorsInfo> selectByExample(SubcontractorsInfoExample example);
    List<SubcontractorsInfo> selectAll();
    List<SubcontractorsInfo> getListByPage(SubcontractorsInfoDto subcontractorsInfoDto);
    SubcontractorsInfo selectByPrimaryKey(Integer id);
    /**
     * 批量导入excel
     * @param file
     * @return
     */
    SubcontractorsInfoVo importExcel(MultipartFile file);
    /**
     * 批量导入excel
     * @param list
     * @return
     */
    Map<String, Integer> deleteByList(List<Integer> list);
}
