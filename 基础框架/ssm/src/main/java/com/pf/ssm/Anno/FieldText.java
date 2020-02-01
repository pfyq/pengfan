package com.pf.ssm.Anno;

import java.lang.annotation.*;

/*属性取别名*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FieldText {
    /**
     * 导入字段所对应的列
     *
     * @return
     */
    public String value() default "";//导入字段所对应的列

    /**
     * 当该字段所匹配到的值不为空时，会进行正则匹配，匹配成功才会装配该对象，否则会被舍弃
     *
     * @return
     */
    public String pattern() default ".*?";//正则表达式筛选

    public String fieldName() default "";//映射的字符名，比value优先级要高
    
    public boolean isSelect() default false;//是否是选择框

}
