package com.formssi.third.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2020/09/12
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcontractorsInfo implements Serializable {
    @ApiModelProperty(value = "分包单位编号")
    private Integer subcontractorsId;

    @ApiModelProperty(value = "分包单位名称")
    private String subcontractorsName;

    @ApiModelProperty(value = "分包单位地区")
    private String subcontractorsArea;

    @ApiModelProperty(value = "分包单位状态0-停用1-正常")
    private String subcontractorsStates;

    @ApiModelProperty(value = "涉及工种")
    private String workerType;

    @ApiModelProperty(value = "分包单位负责人A")
    private Integer principalA;

    @ApiModelProperty(value = "分包单位负责人A电话")
    private String phoneA;

    @ApiModelProperty(value = "分包负责人B")
    private Integer principalB;

    @ApiModelProperty(value = "分包负责人B电话")
    private String phoneB;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "创建日期")
    private String createDate;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "最近修改人")
    private String updateUser;

    @ApiModelProperty(value = "最近修改日期")
    private String updateDate;

    @ApiModelProperty(value = "最近修改时间")
    private String updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subcontractorsId=").append(subcontractorsId);
        sb.append(", subcontractorsName=").append(subcontractorsName);
        sb.append(", subcontractorsArea=").append(subcontractorsArea);
        sb.append(", subcontractorsStates=").append(subcontractorsStates);
        sb.append(", workerType=").append(workerType);
        sb.append(", principalA=").append(principalA);
        sb.append(", phoneA=").append(phoneA);
        sb.append(", principalB=").append(principalB);
        sb.append(", phoneB=").append(phoneB);
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