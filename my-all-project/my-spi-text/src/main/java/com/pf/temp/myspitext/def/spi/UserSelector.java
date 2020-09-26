package com.pf.temp.myspitext.def.spi;

import com.pf.temp.myspitext.def.entity.UserDO;
import com.pf.temp.myspitext.exception.NoSpiMatchException;
import com.pf.temp.myspitext.selector.api.ISelector;
import com.pf.temp.myspitext.selector.api.SpiImplWrapper;

import java.util.Map;

public class UserSelector implements ISelector<UserDO> {

    @Override
    public <K> K selector(Map<String, SpiImplWrapper<K>> map, UserDO conf) throws NoSpiMatchException {

        if (conf == null || conf.getMarket() == null) {
            throw new IllegalArgumentException("userDo or userDO#market should not be null!");
        }


        String name = conf.getMarket().getName();
        if (map.containsKey(name)) {
            return map.get(name).getSpiImpl();
        }


        throw new NoSpiMatchException("no spiImp matched marked: " + conf.getMarket());
    }
}
