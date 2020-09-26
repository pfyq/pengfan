package com.pf.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author pengfan
 * @since 2019-12-18
 */
public class Act extends Model<Act> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动名
     */
    private String title;

    /**
     * 类型
     */
    private String type;

    /**
     * 海报
     */
    @TableField("posterPath")
    private String posterPath;

    /**
     * 开始时间
     */
    @TableField("startTime")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @TableField("endTime")
    private LocalDateTime endTime;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 详细地址
     */
    @TableField("detailPath")
    private String detailPath;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 服务电话
     */
    @TableField("serverPhone")
    private String serverPhone;

    /**
     * 联系电话
     */
    @TableField("contactPhone")
    private String contactPhone;

    /**
     * 浏览数
     */
    private Integer lookNum;

    /**
     * 转发数量
     */
    private Integer forwardNum;

    /**
     * 报名数
     */
    private Integer joinNum;

    /**
     * 活动标签
     */
    private String tags;

    /**
     * 历史浏览数
     */
    private Integer oldLook;

    /**
     * 历史转发数
     */
    private Integer oldForward;

    /**
     * 历史参加人数
     */
    private Integer oldJoin;

    /**
     * 历史总收入
     */
    private BigDecimal oldIncome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
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
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDetailPath() {
        return detailPath;
    }

    public void setDetailPath(String detailPath) {
        this.detailPath = detailPath;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getServerPhone() {
        return serverPhone;
    }

    public void setServerPhone(String serverPhone) {
        this.serverPhone = serverPhone;
    }
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public Integer getLookNum() {
        return lookNum;
    }

    public void setLookNum(Integer lookNum) {
        this.lookNum = lookNum;
    }
    public Integer getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
    }
    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    public Integer getOldLook() {
        return oldLook;
    }

    public void setOldLook(Integer oldLook) {
        this.oldLook = oldLook;
    }
    public Integer getOldForward() {
        return oldForward;
    }

    public void setOldForward(Integer oldForward) {
        this.oldForward = oldForward;
    }
    public Integer getOldJoin() {
        return oldJoin;
    }

    public void setOldJoin(Integer oldJoin) {
        this.oldJoin = oldJoin;
    }
    public BigDecimal getOldIncome() {
        return oldIncome;
    }

    public void setOldIncome(BigDecimal oldIncome) {
        this.oldIncome = oldIncome;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Act{" +
        "id=" + id +
        ", title=" + title +
        ", type=" + type +
        ", posterPath=" + posterPath +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", province=" + province +
        ", city=" + city +
        ", district=" + district +
        ", detailPath=" + detailPath +
        ", content=" + content +
        ", serverPhone=" + serverPhone +
        ", contactPhone=" + contactPhone +
        ", lookNum=" + lookNum +
        ", forwardNum=" + forwardNum +
        ", joinNum=" + joinNum +
        ", tags=" + tags +
        ", oldLook=" + oldLook +
        ", oldForward=" + oldForward +
        ", oldJoin=" + oldJoin +
        ", oldIncome=" + oldIncome +
        "}";
    }
}
