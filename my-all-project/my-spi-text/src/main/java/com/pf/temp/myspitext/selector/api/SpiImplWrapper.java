package com.pf.temp.myspitext.selector.api;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SpiImplWrapper<T> implements Comparable<SpiImplWrapper>  {

    public static final int DEFAULT_ORDER = 10;

    private T spiImpl;

    private int order;


    /**
     * spiImpl 的标识name, 要求唯一
     * <p/>
     * {@link DefaultSelector 选择具体的SpiImpl 时使用}
     */
    private String name;


    /**
     * 参数校验规则
     * <p/>
     * {@link ParamsSelector} 选择具体的SpiImpl 时使用
     * 要求每个实现类都有注解  {@link SpiConf}
     */
    private Map<String, String> paramCondition;


    @Override
    public int compareTo(SpiImplWrapper o) {
        if (o == null) {
            throw new IllegalArgumentException("compable object should not be null!");
        }
        return order - o.getOrder();
    }
}
