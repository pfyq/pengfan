package com.qp.smark.dao;

import com.qp.smark.entity.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    @Select("SELECT * FROM users WHERE name = #{0}")
    List<Users> allOfName(String name);
}