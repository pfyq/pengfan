package com.pf.excel.readExcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelTemplate {

    @ExcelProperty(index = 0,value = "")
    private String listA;

    @ExcelProperty(index = 1,value = "")
    private String listB;

    @ExcelProperty(index = 2,value = "")
    private String listC;

    @ExcelProperty(index = 3,value = "")
    private String listD;

    @ExcelProperty(index = 4,value = "")
    private String listE;
}
