package com.pf.temp.myspitext.adaptive.code;

import com.pf.temp.myspitext.anno.Spi;
import com.pf.temp.myspitext.anno.SpiAdaptive;
import com.pf.temp.myspitext.selector.ParamsSelector;
import com.pf.temp.myspitext.selector.api.Context;

@Spi
public interface ICode {

    void print(String name, String contet);


    @SpiAdaptive
    void echo(String name, String content);


    @SpiAdaptive(selector = ParamsSelector.class)
    void write(Context context, String content);


    @SpiAdaptive(selector = ParamsSelector.class)
    void pp(Context context, String content);
}
