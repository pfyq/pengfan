package com.pf.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author pengfan
 * @since 2019-12-20
 */
public class Applyitems extends Model<Applyitems> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 报名项名称
     */
    private String name;

    /**
     * 是否需要 0:没必要  1:必须
     */
    @TableField("necessityIs")
    private Integer necessityIs;

    /**
     * 活动id
     */
    @TableField("actId")
    private Integer actId;

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
    public Integer getNecessityIs() {
        return necessityIs;
    }

    public void setNecessityIs(Integer necessityIs) {
        this.necessityIs = necessityIs;
    }
    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Applyitems{" +
        "id=" + id +
        ", name=" + name +
        ", necessityIs=" + necessityIs +
        ", actId=" + actId +
        "}";
    }
}
