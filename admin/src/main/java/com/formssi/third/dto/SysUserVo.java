package com.formssi.third.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserVo {
    @ApiModelProperty(value = "工号")
    private String userName;
    @ApiModelProperty(value = "员工姓名")
    private String nickName;
    @ApiModelProperty(value = "部门编号")
    private Integer departmentId;
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    @ApiModelProperty(value = "职位编号")
    private Integer positionId;
    @ApiModelProperty(value = "职位名称")
    private String positionName;
    @ApiModelProperty(value = "证件号")
    private String certId;
}
