/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：IsShow.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-3-31上午10:18:31	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 属性是否存在且隐藏
 * @author 15895085799 
 * @create 2018-3-31 上午10:18:31
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Hidden {
   
}
