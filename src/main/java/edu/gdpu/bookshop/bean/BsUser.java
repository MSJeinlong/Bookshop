package edu.gdpu.bookshop.bean;

import java.util.Date;

public class BsUser {
    private Integer userId;

    private String cellphone;

    private String password;

    private String nickname;

    private String gender;

    private String email;

    private String qq;

    private String wechat;

    private Date birthday;

    private String province1;

    private String city1;

    private String district1;

    private String street1;

    private String province2;

    private String city2;

    private String district2;

    private String street2;

    private String postcode;

    private String cardno;

    private Byte status;

    private Date loginTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProvince1() {
        return province1;
    }

    public void setProvince1(String province1) {
        this.province1 = province1 == null ? null : province1.trim();
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1 == null ? null : city1.trim();
    }

    public String getDistrict1() {
        return district1;
    }

    public void setDistrict1(String district1) {
        this.district1 = district1 == null ? null : district1.trim();
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1 == null ? null : street1.trim();
    }

    public String getProvince2() {
        return province2;
    }

    public void setProvince2(String province2) {
        this.province2 = province2 == null ? null : province2.trim();
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2 == null ? null : city2.trim();
    }

    public String getDistrict2() {
        return district2;
    }

    public void setDistrict2(String district2) {
        this.district2 = district2 == null ? null : district2.trim();
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2 == null ? null : street2.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}