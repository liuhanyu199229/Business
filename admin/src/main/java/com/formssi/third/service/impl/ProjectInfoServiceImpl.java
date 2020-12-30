package com.formssi.third.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.formssi.third.common.api.ResultCode;
import com.formssi.third.common.exception.ApiException;
import com.formssi.third.dao.ProjectInfoDao;
import com.formssi.third.dto.ProjectInfoDto;
import com.formssi.third.dto.ProjectInfoModel;
import com.formssi.third.dto.ProjectInfoVo;
import com.formssi.third.mapper.ProjectInfoMapper;
import com.formssi.third.model.ProjectInfo;
import com.formssi.third.model.ProjectInfoExample;
import com.formssi.third.service.ProjectInfoService;
import com.formssi.third.util.ExcelUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Resource
    ProjectInfoMapper mapper;
    @Autowired
    private ProjectInfoDao projectInfoDao;
    @Override
    public int insertSelective(ProjectInfo info) {
        int count = mapper.insertSelective(info);
        return count;
    }

    @Override
    public int updateByPrimaryKeySelective(ProjectInfo info) {
        int count = mapper.updateByPrimaryKeySelective(info);
        return count;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int count = mapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public List<ProjectInfo> selectByExample(ProjectInfoExample example) {
        List<ProjectInfo> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ProjectInfo> selectAll() {
        ProjectInfoExample example = new ProjectInfoExample();
        example.createCriteria().andProjectIdIsNotNull();
        List<ProjectInfo> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ProjectInfo> getListByPage(ProjectInfoDto projectInfoDto) {
        PageHelper.startPage(projectInfoDto.getPageNum(), projectInfoDto.getPageSize());
        return projectInfoDao.getListByPage(projectInfoDto);
    }

    @Override
    public ProjectInfo selectByPrimaryKey(Integer id) {
        ProjectInfo info = mapper.selectByPrimaryKey(id);
        return info;
    }

    @Override
    public ProjectInfoVo importExcel(MultipartFile file) {
        //判断是否有上传文件
        if (file == null) {
            throw new ApiException(ResultCode.NOFILE);
        }
//        UmsAdmin umsAdmin = commonService.getLoginUserInfo();
        //解析excel文件
        List<ProjectInfoModel> ProjectInfoModels = null;
        try{
            ProjectInfoModels = ExcelUtil.importExcel(file, 0, 1, ProjectInfoModel.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new ApiException(ResultCode.ANALYSIS_FILE_FAILED);
        }
        //去掉集合中所有为空的对象
        ProjectInfoModels.removeAll(Collections.singleton(new ProjectInfoModel()));
        if (CollectionUtil.isEmpty(ProjectInfoModels)) {
            throw new ApiException(ResultCode.ANALYSIS_FILE_EMPTY);
        }
        //获取解析出来的数据总数
        ProjectInfoVo projectInfoVo = new ProjectInfoVo();
        int size = ProjectInfoModels.size();
        projectInfoVo.setTotal(size);

        //根据项目名称对所有的表格中的对象去重
        Set<ProjectInfoModel> set = new TreeSet<>(Comparator.comparing(ProjectInfoModel::getProjectName));
        set.addAll(ProjectInfoModels);
        ProjectInfoModels = new ArrayList<>(set);
        projectInfoVo.setRepeatNum(size - ProjectInfoModels.size());

        List<ProjectInfo> projectList = new ArrayList<>();
        for (ProjectInfoModel projectExcel : ProjectInfoModels) {
            ProjectInfo projectInfo = new ProjectInfo();
            BeanUtil.copyProperties(projectExcel,projectInfo);
//            projectInfo.setCreateUser(umsAdmin.getUsername());
            projectInfo.setCreateUser("test");
            projectList.add(projectInfo);
            projectInfoVo.setSuccessNum(projectList.size());
        }
        projectInfoDao.insertBatch(projectList);
        return projectInfoVo;
    }

    @Override
    public Map<String, Integer> deleteByList(List<Integer> list) {
        Map<String, Integer> map = new HashMap();
        ProjectInfoExample example = new ProjectInfoExample();
        example.createCriteria().andProjectIdIn(list);
        int num = mapper.deleteByExample(example);
        map.put("delNum",num);
        return map;
    }
}
