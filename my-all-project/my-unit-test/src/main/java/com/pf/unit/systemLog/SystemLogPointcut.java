package com.pf.unit.systemLog;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

import java.lang.reflect.Method;
import java.util.Objects;

public class SystemLogPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 查找类上@SystemLog注解属性
        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
                targetClass, SystemLog.class, false, false);
        if (Objects.nonNull(attributes)) {
            return true;
        }
        // 查找方法上@SystemLog注解属性
        attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
                method, SystemLog.class, false, false);
        return Objects.nonNull(attributes);
    }
}
