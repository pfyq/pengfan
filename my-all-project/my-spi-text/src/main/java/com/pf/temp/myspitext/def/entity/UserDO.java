package com.pf.temp.myspitext.def.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDO {

    private String uname;

    private String avatar;

    private MarketEnum market;
}
