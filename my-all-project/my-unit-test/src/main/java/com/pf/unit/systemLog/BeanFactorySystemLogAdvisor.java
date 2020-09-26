package com.pf.unit.systemLog;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

public class BeanFactorySystemLogAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    /**
     * 定义切点
     */
    private final SystemLogPointcut point = new SystemLogPointcut();

    @Override
    public Pointcut getPointcut() {
        return this.point;
    }
}
