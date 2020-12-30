package com.formssi.third.controller;

import cn.hutool.core.lang.Validator;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.formssi.third.common.api.CommonPage;
import com.formssi.third.common.api.CommonResult;
import com.formssi.third.common.api.ResultCode;
import com.formssi.third.common.enums.AccountTypeEnum;
import com.formssi.third.dto.*;
import com.formssi.third.model.UmsAdmin;
import com.formssi.third.model.UmsPermission;
import com.formssi.third.model.UmsRole;
import com.formssi.third.service.UmsAdminService;
import com.formssi.third.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Slf4j
@RestController
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@Valid @RequestBody UmsAdminParam umsAdminParam, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                //日志打印不符合校验的字段名和错误提示
                log.error("error field is : {} ,message is : {}", fieldError.getField(), fieldError.getDefaultMessage());
            });
        }
        //校验手机号
        if(!Validator.isMobile(umsAdminParam.getMobile())){
            return CommonResult.failed(ResultCode.ILLEGAL_MOBILE);
        }
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }else{
            List<Long> list = new ArrayList<>();
            list.add(2L);
            adminService.updateRole(umsAdmin.getId(), list);
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult getAdminInfo(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        //账号属性默认为admin
        String role = "admin";
        if(umsAdmin.getAccountType().intValue()== AccountTypeEnum.SUPPLIER.getCode().intValue()){
            role = "supplier";
        }
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("role", role);
        data.put("roles", adminService.getRoleList(umsAdmin.getId()));
        data.put("menus", roleService.getMenuTree(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        return CommonResult.success(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResult logout(Principal principal) {
        if(principal==null){
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        adminService.logout(umsAdmin);
        return CommonResult.success();
    }

    @ApiOperation("分页获取用户列表")
    @PostMapping(value = "/list")
    @ResponseBody
    public CommonResult<CommonPage<UmsAdminVo>> getAdminList(@RequestBody UmsAdminDto2 dto) {
        List<UmsAdminVo> adminList = adminService.list(dto);
        return CommonResult.success(CommonPage.restPage(adminList));
    }

    @ApiOperation("下载用户信息")
    @PostMapping("/download")
    @ResponseBody
    public void download(@RequestBody UmsAdminDto2 dto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        List<AdminExcelModel> adminList = adminService.list2(dto);
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("用户信息", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            log.info("开始写入excel");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), AdminExcelModel.class).autoCloseStream(Boolean.FALSE).sheet("用户")
                    .doWrite(adminList);
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

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<UmsAdminVo> getItem(@PathVariable Long id) {
        UmsAdminVo admin = adminService.getItem(id);
        return CommonResult.success(admin);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody UmsAdmin admin) {
        int count = adminService.update(admin);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    
    @ApiOperation("重置用户密码")
    @RequestMapping(value = "/resetPassword/{id}",method = RequestMethod.PUT)
    public CommonResult resetPassword(@PathVariable("id") Long id) {
        int count = adminService.resetPassword(id);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改指定用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public CommonResult updatePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int count = adminService.updatePassword(updatePasswordParam);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult delete(@PathVariable Long id) {
        int count = adminService.delete(id);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    public CommonResult updateStatus(@PathVariable Long id,@RequestParam(value = "status") Integer status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        umsAdmin.setId(id);
        int count = adminService.update(umsAdmin);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }
    @ApiOperation("批量修改帐号状态")
    @RequestMapping(value = "/updateBatch", method = RequestMethod.POST)
    public CommonResult updateBatch(@RequestBody UmsAdminDto1 dto) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(dto.getStatus());
        int count = adminService.updateBatch(dto.getList(),umsAdmin);
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public CommonResult updateRole(@RequestBody UmsAdminDto dto) {
        int count = adminService.updateRole(dto.getAdminId(), dto.getList());
        if (count >= 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    public CommonResult updatePermission(@RequestBody UmsAdminDto dto) {
        int count = adminService.updatePermission(dto.getAdminId(), dto.getList());
        if (count > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

}
