package com.formssi.third.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@HeadRowHeight(value = 20)
@ColumnWidth(value = 40)
public class AdminExcelModel {
    @ExcelProperty(value = "序号")
    private String id;
    @ExcelProperty(value = "姓名")
    private String userName;
    @ExcelProperty(value = "工号")
    private String note;
    @ExcelProperty(value = "手机号")
    private String mobile;
    @ExcelProperty(value = "手机号")
    private String projects;
    @ExcelProperty(value = "职位")
    private String job;
    @ExcelProperty(value = "所属部门")
    private String dept;
    @ExcelProperty(value = "角色")
    private String roleName;
    @ExcelProperty(value = "创建时间")
    private String createTime;
    @ExcelProperty(value = "是否启用")
    private String status;
}
