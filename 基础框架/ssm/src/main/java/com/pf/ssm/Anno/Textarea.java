/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName：Textarea.java
 * 
 * Description：
 * 
 * History：
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-29下午3:24:02	       Create	
 */
package com.pf.ssm.Anno;

import java.lang.annotation.*;

/**
 * 标志位文本域
 * @author 15895085799 
 * @create 2018-5-29 下午3:24:02
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Textarea {

}
