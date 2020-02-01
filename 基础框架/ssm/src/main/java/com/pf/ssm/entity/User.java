/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName��User.java
 * 
 * Description��
 * 
 * History��
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-19����11:23:15	       Create	
 */
package com.pf.ssm.entity;


import com.pf.ssm.Anno.FieldText;
import com.pf.ssm.Anno.Hidden;
import com.pf.ssm.Anno.ShowNot;

/**
 * 用户表
 * @author 15895085799
 * @create 2018-5-19 上午11:23:15
 * @version 1.0
 * @since 1.0
 */
public class User {
    @FieldText("ID")
    @Hidden
    private Integer id;//主键
    @FieldText("账号名")
    @ShowNot
    private String name;//账号名
    @FieldText("密码")
    @ShowNot
    private String password;//密码
    @FieldText("等级")
    @ShowNot
    private Integer level;//等级
    @FieldText("真实姓名")
    private String real_name;//真实姓名
    @FieldText("省市id")
    @ShowNot
    private Integer province_id;//省市id
    @FieldText("市县id")
    @ShowNot
    private Integer city_id;//市县id;
    @FieldText("手机号")
    private String phone;//手机号
    @FieldText("邮箱")
    @ShowNot
    private String email;//邮箱
    @FieldText("qq")
    @ShowNot
    private String qq;//qq号
    @FieldText("微博")
    @ShowNot
    private String blog;//微博号
    @FieldText("学校id")
    @ShowNot
    private Integer school_id;//学校id
    @FieldText("班级")
    @ShowNot
    private String grade_name;//班级

    @FieldText("省市")
    @ShowNot
    private String province;//省市
    @FieldText("市县")
    @ShowNot
    private String city;//市县
    @FieldText("学校")
    @ShowNot
    private String school;//学校


    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getGrade_name() {
        return grade_name;
    }
    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }
    public Integer getSchool_id() {
        return school_id;
    }
    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getReal_name() {
        return real_name;
    }
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }
    public Integer getProvince_id() {
        return province_id;
    }
    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }
    public Integer getCity_id() {
        return city_id;
    }
    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getBlog() {
        return blog;
    }
    public void setBlog(String blog) {
        this.blog = blog;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password
                + ", level=" + level + ", real_name=" + real_name
                + ", province_id=" + province_id + ", city_id=" + city_id
                + ", phone=" + phone + ", email=" + email + ", qq=" + qq
                + ", blog=" + blog + ", school_id=" + school_id
                + ", grade_name=" + grade_name + "]";
    }
}
