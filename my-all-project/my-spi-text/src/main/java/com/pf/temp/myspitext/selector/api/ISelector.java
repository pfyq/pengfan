package com.pf.temp.myspitext.selector.api;

import com.pf.temp.myspitext.exception.NoSpiMatchException;

import java.util.Map;

public interface ISelector<T> {

    <K> K selector(Map<String, SpiImplWrapper<K>> map, T conf) throws NoSpiMatchException;
}
