package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UmsAdminDto1 {
    @NotBlank(message = "status is not null")
    @ApiModelProperty(value = "用户ID" )
    private Integer status;
    @ApiModelProperty(value = "角色ID" )
    private List<Long> list;
}
