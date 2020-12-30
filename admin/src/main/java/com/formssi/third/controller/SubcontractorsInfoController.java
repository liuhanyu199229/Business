package com.formssi.third.controller;

import com.formssi.third.annotation.Log;
import com.formssi.third.common.api.CommonPage;
import com.formssi.third.common.api.CommonResult;
import com.formssi.third.dto.SubcontractorsInfoDto;
import com.formssi.third.dto.SubcontractorsInfoVo;
import com.formssi.third.model.SubcontractorsInfo;
import com.formssi.third.service.SubcontractorsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@Api(tags = "SubcontractorsInfo", description = "分包单位管理")
@RequestMapping("/subcontractorsInfo")
public class SubcontractorsInfoController {
    @Autowired
    SubcontractorsInfoService service;
    @ApiOperation("新增分包单位信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public CommonResult insert(@RequestBody SubcontractorsInfo info){
        int count = service.insertSelective(info);
        if (count>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation("修改分包单位信息")
    @PutMapping(value = "/update")
    @ResponseBody
    public CommonResult update(@RequestBody SubcontractorsInfo info){
        int count = service.updateByPrimaryKeySelective(info);
        if (count>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation("删除分包单位信息")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult delete(Integer id){
        int count = service.deleteByPrimaryKey(id);
        if (count>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation(value = "查询分包单位列表")
    @GetMapping(value = "/getList")
    @Log(operate = "查询全部分包单位列表", module = "分包单位管理模块")
    @ResponseBody
    public CommonResult getListAll(){
        List<SubcontractorsInfo> list = service.selectAll();
        return CommonResult.success(list);
    }
    @ApiOperation(value = "查询分页分包单位列表")
    @PostMapping(value = "/getListByPage")
    @Log(operate = "查询分页分包单位列表", module = "分包单位管理模块")
    @ResponseBody
    public CommonResult getListByPage(@RequestBody(required = false) SubcontractorsInfoDto subcontractorsInfoDto){
        List<SubcontractorsInfo> list = service.getListByPage(subcontractorsInfoDto);
        return CommonResult.success(CommonPage.restPage(list));
    }
    @ApiOperation("查询分包单位详情")
    @PostMapping(value = "/findDetail/{id}")
    @ResponseBody
    public CommonResult findDetail(Integer id){
        SubcontractorsInfo info = service.selectByPrimaryKey(id);
        return CommonResult.success(info);
    }
    @ApiOperation(value = "批量导入分包单位")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SubcontractorsInfoVo> importExcel(@ApiParam(value = "项目信息文件",required = true) MultipartFile file) {
        SubcontractorsInfoVo subcontractorsInfoVo = service.importExcel(file);
        return CommonResult.success(subcontractorsInfoVo);
    }
    @ApiOperation("批量删除分包单位信息")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult<Map<String, Integer>> downloadProjects(@RequestBody List<Integer> list){
        Map<String, Integer> map = service.deleteByList(list);
        return CommonResult.success(map);
    }
}
