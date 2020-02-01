package com.qp.smark.dao;

import com.qp.smark.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);


    List<Goods> all(Map<String,Object> map);

    Long count(Map<String,Object> map);
}