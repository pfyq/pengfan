package com.qp.smark.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Users implements Serializable {
    /**
    * 
    */
    private Integer id;

    /**
    * 用户姓名
    */
    private String name;

    /**
    * 用户密码
    */
    private String password;

    /**
    * 账号权限
    */
    private Integer level;

    /**
    * 真实姓名
    */
    private String realName;

    /**
    * 省市表ID
    */
    private Integer provinceId;

    /**
    * 市县表id
    */
    private Integer cityId;

    /**
    * 手机号
    */
    private String phone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * QQ
    */
    private String qq;

    /**
    * 微博
    */
    private String blog;

    /**
    * 学校id
    */
    private Integer schoolId;

    /**
    * 班级
    */
    private String gradeName;

    private static final long serialVersionUID = 1L;
}