package edu.gdpu.bookshop.bean;

import java.math.BigDecimal;

public class Order {
    private Integer orderId;

    private String orderName;

    private Integer userId;

    private BigDecimal cost;

    private String cardno;

    private Integer statusId;

    private Integer paywayId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getPaywayId() {
        return paywayId;
    }

    public void setPaywayId(Integer paywayId) {
        this.paywayId = paywayId;
    }
}