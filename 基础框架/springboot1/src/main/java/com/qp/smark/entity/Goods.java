package com.qp.smark.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Goods implements Serializable {
    /**
    * 
    */
    private Integer id;

    /**
    * 活动链接
    */
    @ApiModelProperty(value = "活动链接")
    private String url;

    /**
    * 海报链接
    */
    @ApiModelProperty(value = "海报链接")
    private String posterUrl;

    /**
    * 活动标题
    */
    @ApiModelProperty(value = "活动标题")
    private String title;

    /**
    * 
    */
    @ApiModelProperty(value = "活动备注")
    private String remark;

    /**
    * 活动副标题
    */
    @ApiModelProperty(value = "活动副标题")
    private String assTitle;

    /**
    * 类型id
    */
    @ApiModelProperty(value = "活动类型id")
    private Integer typeId;

    /**
    * 截止时间
    */
    @ApiModelProperty(value = "活动截止时间")
    private Date endDate;

    /**
    * 活动头图
    */
    @ApiModelProperty(value = "活动头图")
    private String headUrl;

    /**
    * 详情
    */
    @ApiModelProperty(value = "活动详情")
    private String content;

    /**
    * 原价
    */
    @ApiModelProperty(value = "活动原价")
    private Long price;

    /**
    * 特价
    */
    @ApiModelProperty(value = "活动特价")
    private Long specialPrice;

    @JsonFormat(pattern="yyyy/MM/dd HH:mm", timezone = "GMT+8")
    private Date create_date;

    @ApiModelProperty(value = "活动限购量")
    private Integer limitation;

    private static final long serialVersionUID = 1L;
}