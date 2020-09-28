package com.tcp.tcpchat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Date;




@Setter
@Getter
@ToString
public class User implements Serializable {
    private String userId;
    private String userEmail;
    private String userPassword;
    private String userNikename;
    private Date userTime;//注册时间
    private String userSex;
    private int userStatus;
    private String userStatusStr;
    private String userImg;
    private Date userBirthday;
    private String userPersonalized;
    private String realName;
    private Integer userMessageNum;

    public Integer getUserMessageNum() {
        return userMessageNum;
    }

    public void setUserMessageNum(Integer userMessageNum) {
        this.userMessageNum = userMessageNum;
    }

    public String getUserPersonalized() {
        return userPersonalized;
    }

    public void setUserPersonalized(String userPersonalized) {
        this.userPersonalized = userPersonalized;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNikename() {
        return userNikename;
    }

    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename;
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatusStr() {
        return userStatusStr;
    }

    public void setUserStatusStr(String userStatusStr) {
        this.userStatusStr = userStatusStr;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNikename='" + userNikename + '\'' +
                ", userTime=" + userTime +
                ", userSex='" + userSex + '\'' +
                ", userStatus=" + userStatus +
                ", userStatusStr='" + userStatusStr + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPersonalized='" + userPersonalized + '\'' +
                ", realName='" + realName + '\'' +
                ", userMessageNum=" + userMessageNum +
                '}';
    }
}
