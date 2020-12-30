package com.formssi.third.dto;

import com.formssi.third.common.api.CommonPageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubcontractorsInfoDto extends CommonPageParam {
    @ApiModelProperty(value = "分包单位名称")
    private String subcontractorsName;

    @ApiModelProperty(value = "分包单位负责人")
    private Integer principal;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "项目地区")
    private String subcontractorsArea;
}
