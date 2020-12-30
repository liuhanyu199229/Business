package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UmsRoleDto1 {
    @NotBlank(message = "roleId不能为空")
    @ApiModelProperty(value = "角色ID" )
    private Long roleId;
    @ApiModelProperty(value = "角色ID" )
    private List<Long> list;
}
