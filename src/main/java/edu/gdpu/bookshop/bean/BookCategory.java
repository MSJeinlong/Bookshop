package edu.gdpu.bookshop.bean;

public class BookCategory {
    private Integer categoryId;

    private String categoryName;

    private String categoryAttr;

    private Integer bookNums;

    private Byte isEbook;

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

    public Byte getIsEbook() {
        return isEbook;
    }

    public void setIsEbook(Byte isEbook) {
        this.isEbook = isEbook;
    }
}