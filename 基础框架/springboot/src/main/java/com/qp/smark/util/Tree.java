package com.qp.smark.util;


/**
 * 针对easyui的树的工具类
 * @author 15895085799
 * @create 2018-5-27 上午8:53:35
 * @version 1.0
 * @since 1.0
 */

public class Tree {

    private String id;//节点的id
    private String text;//节点的文本
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return "Tree [id=" + id + ", text=" + text + "]";
    }

}
