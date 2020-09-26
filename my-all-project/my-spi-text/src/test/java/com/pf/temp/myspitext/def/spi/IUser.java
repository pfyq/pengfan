package com.pf.temp.myspitext.def.spi;

import com.pf.temp.myspitext.anno.Spi;
import com.pf.temp.myspitext.anno.SpiAdaptive;
import com.pf.temp.myspitext.def.entity.UserDO;

@Spi
public interface IUser {

    @SpiAdaptive(selector = UserSelector.class)
    void welcome(UserDO userDO);
}
