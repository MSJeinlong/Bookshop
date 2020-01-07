package edu.gdpu.bookshop.bean;

import java.util.Date;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String password;

    private Boolean loginStatus;

    private Date lastestLoginTime;

    private Date signOutTime;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLastestLoginTime() {
        return lastestLoginTime;
    }

    public void setLastestLoginTime(Date lastestLoginTime) {
        this.lastestLoginTime = lastestLoginTime;
    }

    public Date getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Date signOutTime) {
        this.signOutTime = signOutTime;
    }
}