/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：OtherField.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-26上午10:21:30	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 标记是否是外表属性
 * @author 15895085799 
 * @create 2018-5-26 上午10:21:30
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OtherField {

    public String value() default "";//对应的域名的别名
}
