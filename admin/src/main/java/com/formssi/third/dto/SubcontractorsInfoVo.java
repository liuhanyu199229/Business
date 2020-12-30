package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SubcontractorsInfoVo {
    @ApiModelProperty(value = "excel中项目总数量")
    private Integer total;

    @ApiModelProperty(value = "导入成功数量")
    private Integer successNum;

    @ApiModelProperty(value = "excel中项目名称重复数量")
    private Integer repeatNum;

    @ApiModelProperty(value = "导入失败数量")
    private Integer failNum;

    @ApiModelProperty(value = "导入失败项目")
    private List<ProjectInfoModel> projectList;
}
