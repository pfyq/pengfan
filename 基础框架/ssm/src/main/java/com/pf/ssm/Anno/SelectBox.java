/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：SelectBox.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-22下午8:27:27	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 属性是否对应下拉框
 * @author 15895085799 
 * @create 2018-5-22 下午8:27:27
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SelectBox {

    public String value() default "";//保存信息
}
