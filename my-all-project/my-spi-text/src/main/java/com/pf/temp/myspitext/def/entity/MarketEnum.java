package com.pf.temp.myspitext.def.entity;

public enum MarketEnum {

    WEIXIN("WeixinUser"),

    QQ("QQUser");

    private String name;

    MarketEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
