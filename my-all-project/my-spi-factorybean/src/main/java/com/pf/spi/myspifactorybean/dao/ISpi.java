package com.pf.spi.myspifactorybean.dao;

public interface ISpi<T> {
    /**
     * 根据传入的参数来决定具体的实例来执行
     * */
    boolean verify(T condition);

    /**
     * 如果有多个子类都满足这个条件
     * 返回优先级最高的匹配者
     * 排序，数字越小，优先级越高
     * @return
     */
    default int order() {
        return 10;
    }
}
