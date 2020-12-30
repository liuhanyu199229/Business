package com.formssi.third.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class SubcontractorsInfoModel implements Serializable {
    @Excel(name = "分包单位名称(不能为空)", orderNum  = "1")
    private String subcontractorsName;
    @Excel(name = "分包单位地区（城市）(不能为空)", orderNum  = "2")
    private String subcontractorsArea;
    @Excel(name = "涉及工种", orderNum = "3")
    private String workerType;
    @Excel(name = "分包单位负责人A", orderNum  = "4")
    private String principalA;
    @Excel(name = "分包单位负责人A手机号", orderNum  = "5")
    private String phoneA;
    @Excel(name = "分包单位负责人B", orderNum  = "6")
    private String principalB;
    @Excel(name = "分包单位负责人B手机号", orderNum  = "7")
    private String phoneB;

}
