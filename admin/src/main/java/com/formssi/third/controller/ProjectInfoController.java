package com.formssi.third.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.formssi.third.annotation.Log;
import com.formssi.third.common.api.CommonPage;
import com.formssi.third.common.api.CommonResult;
import com.formssi.third.dto.ProjectInfoDto;
import com.formssi.third.dto.ProjectInfoExcelModel;
import com.formssi.third.dto.ProjectInfoVo;
import com.formssi.third.model.ProjectInfo;
import com.formssi.third.service.ProjectInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@Api(tags = "ProjectInfoController", description = "项目管理")
@RequestMapping("/ProjectInfo")
public class ProjectInfoController {
    @Autowired
    ProjectInfoService service;
    @ApiOperation("新增项目信息")
    @PostMapping(value = "/save")
    @ResponseBody
    public CommonResult insert(@RequestBody ProjectInfo info){
        int count = service.insertSelective(info);
        if (count>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation("修改项目信息")
    @PutMapping(value = "/update")
    @ResponseBody
    public CommonResult update(@RequestBody ProjectInfo info){
        int count = service.updateByPrimaryKeySelective(info);
        if (count>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation("删除项目信息")
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public CommonResult delete(Integer id){
        int count = service.deleteByPrimaryKey(id);
        if (count>0){
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation(value = "查询项目列表")
    @GetMapping(value = "/getList")
    @Log(operate = "查询全部项目列表", module = "项目管理模块")
    @ResponseBody
    public CommonResult getListAll(){
        List<ProjectInfo> list = service.selectAll();
        return CommonResult.success(list);
    }
    @ApiOperation(value = "查询分页项目列表")
    @PostMapping(value = "/getListByPage")
    @Log(operate = "查询分页项目列表", module = "项目管理模块")
    @ResponseBody
    public CommonResult getListByPage(@RequestBody(required = false) ProjectInfoDto projectInfoDto){
        List<ProjectInfo> list = service.getListByPage(projectInfoDto);
        return CommonResult.success(CommonPage.restPage(list));
    }
    @ApiOperation("查询项目详情")
    @PostMapping(value = "/findDetail/{id}")
    @ResponseBody
    public CommonResult findDetail(Integer id){
        ProjectInfo info = service.selectByPrimaryKey(id);
        return CommonResult.success(info);
    }
    @ApiOperation(value = "批量导入项目")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ProjectInfoVo> importExcel(@ApiParam(value = "项目信息文件",required = true) MultipartFile file) {
        ProjectInfoVo projectInfoVo = service.importExcel(file);
        return CommonResult.success(projectInfoVo);
    }
    @ApiOperation("批量删除项目信息")
    @PostMapping("/deleteList")
    @ResponseBody
    public CommonResult<Map<String, Integer>> downloadProjects(@RequestBody List<Integer> list){
        Map<String, Integer> map = service.deleteByList(list);
        return CommonResult.success(map);
    }
    @ApiOperation("下载项目信息")
    @PostMapping("/downloadProjects")
    @ResponseBody
    public void downloadProjects(@RequestBody List<ProjectInfoExcelModel> list, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        log.info("入参："+list);
        log.info("入参长度"+list.size());
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("项目信息", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            log.info("开始写入excel");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), ProjectInfoExcelModel.class).autoCloseStream(Boolean.FALSE).sheet("项目")
                    .doWrite(list);
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,HEAD,PUT,PATCH");
            response.setHeader("Access-Control-Max-Age", "36000");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Authorization,authorization");
            response.setHeader("Access-Control-Allow-Credentials","true");
            response.getWriter().println(JSON.toJSONString(CommonResult.failed()));
        }
    }
}
