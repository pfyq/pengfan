package com.example.pengfan.seeimage.util;

public class RegexUtil {


    /*
    * 手机号的正则表达式,可以根据实际情况修改
    * */
    private static final String PHONE_REGEX = "";


    /*
    邮箱正则表达式
    * */
    private static final String EMAIL_REGEX = "";

    /*
    * 判断手机号是否符合规范
    * */
    public static boolean isPhone(String value){
//        return value.matches(PHONE_REGEX);
        return true;
    }

    /*
     * 判断邮箱是否符合规范
     * */
    public static boolean isEmail(String value){
//        return value.matches(EMAIL_REGEX);
        return true;
    }
}
