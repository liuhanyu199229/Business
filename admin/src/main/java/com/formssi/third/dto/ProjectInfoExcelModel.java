package com.formssi.third.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@HeadRowHeight(value = 20)
@ColumnWidth(value = 40)
public class ProjectInfoExcelModel {
    @ExcelProperty(value = "项目编号")
    private String projectId;
    @ExcelProperty(value = "项目名称")
    private String projectName;
    @ExcelProperty(value = "项目类型")
    private String projectType;
    @ExcelProperty(value = "所在区域（城市）")
    private String projectArea;
    @ExcelProperty(value = "项目规模")
    private String projectScale;
    @ExcelProperty(value = "合同开始日期")
    private String contractSDate;
    @ExcelProperty(value = "合同结束日期")
    private String contractEDate;
    @ExcelProperty(value = "合同金额")
    private String contractAmount;
    @ExcelProperty(value = "项目经理")
    private String managerId;
    @ExcelProperty(value = "项目经理手机号")
    private String phoneA;
    @ExcelProperty(value = "项目常务副经理")
    private String deputyManagerId;
    @ExcelProperty(value = "项目常务副经理手机号")
    private String phoneB;
    @ExcelProperty(value = "项目描述")
    private String projectDes;
}
