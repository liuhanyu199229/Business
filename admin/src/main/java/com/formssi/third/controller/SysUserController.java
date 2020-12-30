package com.formssi.third.controller;

import com.formssi.third.common.api.CommonResult;
import com.formssi.third.dto.SysUserVo;
import com.formssi.third.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@Api(tags = "SysUserController", description = "人员信息")
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    SysUserService service;
    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<SysUserVo>> getItem(@RequestParam(value = "name")String name) {
        List<SysUserVo> list  = service.getSysUser(name);
        return CommonResult.success(list);
    }
}
