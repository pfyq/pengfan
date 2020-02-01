/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：Key.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-25下午3:55:34	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 此属性为主键
 * @author 15895085799 
 * @create 2018-5-25 下午3:55:34
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Key {

}
