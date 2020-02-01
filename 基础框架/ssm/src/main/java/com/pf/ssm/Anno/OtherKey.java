/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：OtherKey.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-25下午2:35:10	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 属性是否是其他表的主键
 * @author 15895085799 
 * @create 2018-5-25 下午2:35:10
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OtherKey {

    public String value() default "";//对应的域名的别名
}
