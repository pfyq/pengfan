/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：Show.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-12上午9:49:09	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 属性是否不需要存在
 * @author 15895085799 
 * @create 2018-5-12 上午9:49:09
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ShowNot {
    
}
