package com.pf.myelasticsearchone.entity;

import java.util.List;

public class HuaWeiPhoneBean {

    private String productName;

    private List<String> sellingPoints;

    private List<ColorModeBean> colorsItemMode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ColorModeBean> getColorsItemMode() {
        return colorsItemMode;
    }

    public void setColorsItemMode(List<ColorModeBean> colorsItemMode) {
        this.colorsItemMode = colorsItemMode;
    }

    public List<String> getSellingPoints() {
        return sellingPoints;
    }

    public void setSellingPoints(List<String> sellingPoints) {
        this.sellingPoints = sellingPoints;
    }
}
