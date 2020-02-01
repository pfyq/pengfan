/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName��UserDao.java
 * 
 * Description��
 * 
 * History��
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-5-19����11:28:32	       Create	
 */
package com.pf.ssm.dao;


import com.pf.ssm.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserDao {

    @Select("select users.* FROM users ")
    List<User> all();
    
    @Select("DELETE FROM users WHERE id = #{0}")
    void del(Integer id);
    
    @Insert("INSERT INTO users (ID, NAME, PASSWORD, LEVEL, REAL_NAME, PROVINCE_ID, CITY_ID, PHONE, EMAIL, QQ, BLOG, SCHOOL_ID, GRADE_NAME) VALUES (null,#{name},#{password},#{level},#{real_name},#{province_id},#{city_id},#{phone},#{email},#{qq},#{blog},#{school_id},#{grade_name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insert(User user);
    
    @Update("UPDATE users SET LEVEL=#{level}, REAL_NAME=#{real_name}, PROVINCE_ID=#{province_id}, CITY_ID=#{city_id}, PHONE=#{phone}, EMAIL=#{email}, QQ=#{qq}, BLOG=#{blog}, SCHOOL_ID=#{school_id}, GRADE_NAME=#{grade_name} WHERE ID = #{id} ")
    Integer upd2(User user);
    
//    @Update("UPDATE users SET NAME = #{name} ,PASSWORD = #{password} WHERE ID = #{id} ")
//    Integer upd(UserExtend2 userExtend2);

    @Insert("INSERT INTO users (ID, NAME, PASSWORD, LEVEL, REAL_NAME, PROVINCE_ID, CITY_ID, PHONE, EMAIL, QQ, BLOG, SCHOOL_ID, GRADE_NAME) VALUES (null,#{name},#{password},#{level},#{real_name},#{province_id},#{city_id},#{phone},#{email},#{qq},#{blog},#{school_id},#{grade_name})")
    void add(User user);

    @Select("SELECT * FROM users WHERE name = #{0}")
    List<User> allOfName(String name);

    @Select("SELECT * FROM users WHERE name = #{name} and password = #{password}")
    User validate(User user);

//    @Update("UPDATE users SET PASSWORD = #{password} WHERE ID = #{id} ")
//    Integer updPassword(UserTemplate user);
}
