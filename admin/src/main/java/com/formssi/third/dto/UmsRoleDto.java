package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UmsRoleDto {
    @NotBlank(message = "roleId不能为空")
    @ApiModelProperty(value = "角色ID" )
    private Long roleId;
}
