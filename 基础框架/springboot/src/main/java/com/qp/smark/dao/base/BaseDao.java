package com.qp.smark.dao.base;

import java.util.List;

public interface BaseDao<T> {

    public int insert(T t);

    public int update(T t);

    public int delete(Object id);

//    public int queryByCount(BasePage page);
//
//    public List<T> queryByList(BasePage page);

    public List<T> queryList(T t);

//    public List<T> queryAllValid(BasePage page);

    public T queryById(Object id);
}
