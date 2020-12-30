package com.formssi.third.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2020/09/10
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfo implements Serializable {
    @ApiModelProperty(value = "项目编号")
    private Integer projectId;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目类型")
    private String projectType;

    @ApiModelProperty(value = "项目地区")
    private String projectArea;

    @ApiModelProperty(value = "项目规模0-超特大型项目1-特大型项目2-大型项目3-中小型项目")
    private String projectScale;

    @ApiModelProperty(value = "合同开始日期")
    private String contractSDate;

    @ApiModelProperty(value = "项目结束日期")
    private String contractEDate;

    @ApiModelProperty(value = "项目金额")
    private BigDecimal contractAmount;

    @ApiModelProperty(value = "项目经理")
    private Integer managerId;

    @ApiModelProperty(value = "项目经理手机号")
    private String phoneA;

    @ApiModelProperty(value = "项目常务副经理")
    private Integer deputyManagerId;

    @ApiModelProperty(value = "项目常务副经理手机号")
    private String phoneB;

    @ApiModelProperty(value = "经办人")
    private Integer handleId;

    @ApiModelProperty(value = "项目状态0-未开始1-进行中2-项目结束")
    private String projectStates;

    @ApiModelProperty(value = "项目描述")
    private String projectDes;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "创建日期")
    private String createDate;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "修改日期")
    private String updateDate;

    @ApiModelProperty(value = "修改时间")
    private String updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectType=").append(projectType);
        sb.append(", projectArea=").append(projectArea);
        sb.append(", projectScale=").append(projectScale);
        sb.append(", contractSDate=").append(contractSDate);
        sb.append(", contractEDate=").append(contractEDate);
        sb.append(", contractAmount=").append(contractAmount);
        sb.append(", managerId=").append(managerId);
        sb.append(", phoneA=").append(phoneA);
        sb.append(", deputyManagerId=").append(deputyManagerId);
        sb.append(", phoneB=").append(phoneB);
        sb.append(", handleId=").append(handleId);
        sb.append(", projectStates=").append(projectStates);
        sb.append(", projectDes=").append(projectDes);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}