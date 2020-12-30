package com.formssi.third.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.formssi.third.common.api.ResultCode;
import com.formssi.third.common.exception.ApiException;
import com.formssi.third.dao.SubcontractorsInfoDao;
import com.formssi.third.dto.SubcontractorsInfoDto;
import com.formssi.third.dto.SubcontractorsInfoModel;
import com.formssi.third.dto.SubcontractorsInfoVo;
import com.formssi.third.mapper.SubcontractorsInfoMapper;
import com.formssi.third.model.SubcontractorsInfo;
import com.formssi.third.model.SubcontractorsInfoExample;
import com.formssi.third.service.SubcontractorsInfoService;
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
public class SubcontractorsInfoServiceImpl implements SubcontractorsInfoService {
    @Resource
    SubcontractorsInfoMapper mapper;
    @Autowired
    private SubcontractorsInfoDao dao;
    @Override
    public int insertSelective(SubcontractorsInfo info) {
        int count = mapper.insertSelective(info);
        return count;
    }

    @Override
    public int updateByPrimaryKeySelective(SubcontractorsInfo info) {
        int count = mapper.updateByPrimaryKeySelective(info);
        return count;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int count = mapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public List<SubcontractorsInfo> selectByExample(SubcontractorsInfoExample example) {
        List<SubcontractorsInfo> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public List<SubcontractorsInfo> selectAll() {
        SubcontractorsInfoExample example = new SubcontractorsInfoExample();
        example.createCriteria().andSubcontractorsIdIsNotNull();
        List<SubcontractorsInfo> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public List<SubcontractorsInfo> getListByPage(SubcontractorsInfoDto subcontractorsInfoDto) {
        PageHelper.startPage(subcontractorsInfoDto.getPageNum(), subcontractorsInfoDto.getPageSize());
        return dao.getListByPage(subcontractorsInfoDto);
    }

    @Override
    public SubcontractorsInfo selectByPrimaryKey(Integer id) {
        SubcontractorsInfo info = mapper.selectByPrimaryKey(id);
        return info;
    }

    @Override
    public SubcontractorsInfoVo importExcel(MultipartFile file) {
        //判断是否有上传文件
        if (file == null) {
            throw new ApiException(ResultCode.NOFILE);
        }
//        UmsAdmin umsAdmin = commonService.getLoginUserInfo();
        //解析excel文件
        List<SubcontractorsInfoModel> subcontractorsInfoModels = null;
        try{
            subcontractorsInfoModels = ExcelUtil.importExcel(file, 0, 1, SubcontractorsInfoModel.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new ApiException(ResultCode.ANALYSIS_FILE_FAILED);
        }
        //去掉集合中所有为空的对象
        subcontractorsInfoModels.removeAll(Collections.singleton(new SubcontractorsInfoModel()));
        if (CollectionUtil.isEmpty(subcontractorsInfoModels)) {
            throw new ApiException(ResultCode.ANALYSIS_FILE_EMPTY);
        }
        //获取解析出来的数据总数
        SubcontractorsInfoVo subcontractorsInfoVo = new SubcontractorsInfoVo();
        int size = subcontractorsInfoModels.size();
        subcontractorsInfoVo.setTotal(size);

        //根据项目名称对所有的表格中的对象去重
        Set<SubcontractorsInfoModel> set = new TreeSet<>(Comparator.comparing(SubcontractorsInfoModel::getSubcontractorsName));
        set.addAll(subcontractorsInfoModels);
        subcontractorsInfoModels = new ArrayList<>(set);
        subcontractorsInfoVo.setRepeatNum(size - subcontractorsInfoModels.size());

        List<SubcontractorsInfo> subcontractorsInfoList = new ArrayList<>();
        for (SubcontractorsInfoModel subcontractorsInfoExcel : subcontractorsInfoModels) {
            SubcontractorsInfo subcontractorsInfo = new SubcontractorsInfo();
            BeanUtil.copyProperties(subcontractorsInfoExcel,subcontractorsInfo);
//            projectInfo.setCreateUser(umsAdmin.getUsername());
            subcontractorsInfo.setCreateUser("test");
            subcontractorsInfoList.add(subcontractorsInfo);
            subcontractorsInfoVo.setSuccessNum(subcontractorsInfoList.size());
        }
        dao.insertBatch(subcontractorsInfoList);
        return subcontractorsInfoVo;
    }

    @Override
    public Map<String, Integer> deleteByList(List<Integer> list) {
        Map<String, Integer> map = new HashMap();
        SubcontractorsInfoExample example = new SubcontractorsInfoExample();
        example.createCriteria().andSubcontractorsIdIn(list);
        int num = mapper.deleteByExample(example);
        map.put("delNum",num);
        return map;
    }
}
