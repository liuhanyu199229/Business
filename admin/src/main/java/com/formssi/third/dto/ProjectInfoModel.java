package com.formssi.third.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.io.Serializable;
@Data
public class ProjectInfoModel implements Serializable {
    @Excel(name = "项目名称(不能为空)", orderNum  = "1")
    private String projectName;
    @Excel(name = "项目类型(不能为空)", orderNum  = "2")
    private String projectType;
    @Excel(name = "所在区域（城市）(不能为空)", orderNum  = "3")
    private String projectArea;
    @Excel(name = "项目规模", orderNum = "4")
    private String projectScale;
    @Excel(name = "合同开始日期", orderNum  = "5")
    private String contractSDate;
    @Excel(name = "合同结束日期", orderNum  = "6")
    private String contractEDate;
    @Excel(name = "合同金额", orderNum  = "7")
    private String contractAmount;
    @Excel(name = "项目经理(不能为空)", orderNum  = "8")
    private String managerId;
    @Excel(name = "项目经理手机号(不能为空)", orderNum  = "9")
    private String phoneA;
    @Excel(name = "项目常务副经理（不能为空）", orderNum  = "10")
    private String deputyManagerId;
    @Excel(name = "项目常务副经理手机号(不能为空)", orderNum  = "11")
    private String phoneB;
    @Excel(name = "项目描述", orderNum  = "12")
    private String projectDes;
}
