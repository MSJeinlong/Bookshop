package edu.gdpu.bookshop.bean;

import java.util.Date;

public class BookCategory {
    private Integer categoryId;

    private String categoryName;

    private String categoryAttr;

    private Integer bookNums;

    private Date createTime;

    private Date updateTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryAttr() {
        return categoryAttr;
    }

    public void setCategoryAttr(String categoryAttr) {
        this.categoryAttr = categoryAttr == null ? null : categoryAttr.trim();
    }

    public Integer getBookNums() {
        return bookNums;
    }

    public void setBookNums(Integer bookNums) {
        this.bookNums = bookNums;
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
}