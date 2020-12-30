package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminParam {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱格式不合法")
    private String email;

    @ApiModelProperty(value = "用户姓名")
    private String realName;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "账号类型（1官方，2供应商）")
    private Integer accountType;

    @ApiModelProperty(value = "供应商Id")
    private Long businessId;

    @ApiModelProperty(value = "账号状态（0->禁用；1->启用）")
    private Integer status;
}
