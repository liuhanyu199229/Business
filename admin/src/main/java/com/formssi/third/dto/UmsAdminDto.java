package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Data
public class UmsAdminDto {
    @NotBlank(message = "adminId is not null")
    @ApiModelProperty(value = "用户ID" )
    private Long adminId;
    @ApiModelProperty(value = "角色ID" )
    private List<Long> list;
}
