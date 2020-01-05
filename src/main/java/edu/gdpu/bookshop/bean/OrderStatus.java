package edu.gdpu.bookshop.bean;

public class OrderStatus {
    private Integer statusId;

    private String statusName;

    private String satusDesc;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public String getSatusDesc() {
        return satusDesc;
    }

    public void setSatusDesc(String satusDesc) {
        this.satusDesc = satusDesc == null ? null : satusDesc.trim();
    }
}