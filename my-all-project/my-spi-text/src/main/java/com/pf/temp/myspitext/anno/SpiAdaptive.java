package com.pf.temp.myspitext.anno;

import com.pf.temp.myspitext.selector.DefaultSelector;
import com.pf.temp.myspitext.selector.api.ISelector;

import java.lang.annotation.*;

/**
 * SPI 自适应注解, 表示该类or该方法会用到spi实现
 * <p/>
 * Created by yihui on 2017/5/24.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SpiAdaptive {
    Class<? extends ISelector> selector() default DefaultSelector.class;
}
