package com.formssi.third.dto;

import com.formssi.third.common.api.CommonPageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProjectInfoDto extends CommonPageParam {
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目经理")
    private Integer managerId;

    @ApiModelProperty(value = "项目规模")
    private String projectScale;

    @ApiModelProperty(value = "项目地区")
    private String projectArea;

    @ApiModelProperty(value = "项目状态")
    private String projectStates;

    @ApiModelProperty(value = "合同开始日期")
    private String contractSDate;

    @ApiModelProperty(value = "合同结束日期")
    private String contractEDate;
}
