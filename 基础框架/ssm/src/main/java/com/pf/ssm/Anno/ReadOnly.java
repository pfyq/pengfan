/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：ReadOnly.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-3-26下午5:15:58	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 属性是否仅仅被读
 * @author 15895085799 
 * @create 2018-3-26 下午5:15:58
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ReadOnly {
   
}
