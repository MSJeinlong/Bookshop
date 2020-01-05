package edu.gdpu.bookshop.bean;

public class PayWay {
    private Integer paywayId;

    private String paywayName;

    public Integer getPaywayId() {
        return paywayId;
    }

    public void setPaywayId(Integer paywayId) {
        this.paywayId = paywayId;
    }

    public String getPaywayName() {
        return paywayName;
    }

    public void setPaywayName(String paywayName) {
        this.paywayName = paywayName == null ? null : paywayName.trim();
    }
}