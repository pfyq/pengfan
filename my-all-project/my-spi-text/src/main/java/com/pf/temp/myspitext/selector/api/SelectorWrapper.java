package com.pf.temp.myspitext.selector.api;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SelectorWrapper {

    /**
     * 具体的选择器
     */
    private ISelector selector;


    /**
     * 具体选择器对应的条件类型
     */
    private Class conditionType;
}
