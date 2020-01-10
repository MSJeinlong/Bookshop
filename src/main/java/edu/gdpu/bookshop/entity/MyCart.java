package edu.gdpu.bookshop.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MyCart {
    private Integer cartId;

    private Integer userId;

    private Integer bookId;

    private String bookName;

    private String bookImage;

    private BigDecimal bookPrice;

    private Integer bookAmount;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage == null ? null : bookImage.trim();
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        this.bookAmount = bookAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyCart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAmount=" + bookAmount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}