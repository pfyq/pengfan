package com.pf.temp.myspitext.selector;

import com.pf.temp.myspitext.exception.NoSpiMatchException;
import com.pf.temp.myspitext.selector.api.ISelector;
import com.pf.temp.myspitext.selector.api.SpiImplWrapper;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class DefaultSelector implements ISelector<String> {

    @Override
    public <K> K selector(Map<String, SpiImplWrapper<K>> map, String name) throws NoSpiMatchException {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("spiName should not be empty!");
        }

        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException("no impl spi!");
        }


        if (!map.containsKey(name)) {
            throw new NoSpiMatchException("no spiImpl match the name you choose! your choose is: " + name);
        }

        return map.get(name).getSpiImpl();
    }
}
