package com.formssi.third.dto;

import com.formssi.third.common.enums.AccountTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UmsAdminVo {
    private Long id;

    @ApiModelProperty(value = "账号类型（1官方，2部门）")
    private Integer accountType;

    @ApiModelProperty(value = "账号所属")
    private String accountTypeName;

    public String getAccountTypeName(){
        return AccountTypeEnum.getMessage(accountType);
    }

    @ApiModelProperty(value = "部门Id")
    private Long businessId;

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "备注信息")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "最后登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "部门名称")
    private String businessName;

    @ApiModelProperty(value = "部门地址")
    private String businessAddress;

    @ApiModelProperty(value = "部门简介")
    private String businessDescription;
}
