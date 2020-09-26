package com.pf.temp.myspitext.anno;

import com.pf.temp.myspitext.selector.DefaultSelector;
import com.pf.temp.myspitext.selector.api.ISelector;

import java.lang.annotation.*;

/**
 * Created by yihui on 2017/5/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Spi {
    Class<? extends ISelector> selector() default DefaultSelector.class;
}
