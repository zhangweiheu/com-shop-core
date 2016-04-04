package com.shop.core.model;

import com.shop.core.mybatis.ExpressStatusEnum;
import java.io.Serializable;
import java.util.Date;

/**
 * shop.order_form  
 *
 * @author zhang
 * @date 2016-4-3
 *
 */
public class OrderForm implements Serializable {
    /** 订单id */
    private Integer id;

    /** 用户id */
    private Integer uid;

    /** 订单金额 */
    private Double orderPrice;

    /** 0:处理中 | 1:快递已发货 | 2:运送中 | 3:待签收 */
    private ExpressStatusEnum expressStatus;

    /** 优惠码 */
    private String serialNumber;

    /** 创建时间 */
    private Date createAt;

    /** 更新时间 */
    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public ExpressStatusEnum getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(ExpressStatusEnum expressStatus) {
        this.expressStatus = expressStatus;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}