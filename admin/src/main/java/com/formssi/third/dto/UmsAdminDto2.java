package com.formssi.third.dto;

import com.formssi.third.common.api.CommonPageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class UmsAdminDto2 extends CommonPageParam {
    @ApiModelProperty(value = "姓名/手机号" )
    private String name;
    @ApiModelProperty(value = "角色ID" )
    private Long roleId;
    @ApiModelProperty(value = "状态" )
    private Integer status;
}
