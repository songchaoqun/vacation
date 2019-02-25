package com.lyq.model;

import javax.persistence.*;

//网站用户登录注册表表
@Entity
@Table(name="t_sites_user")
public class SitesUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //目录表主键Id

    private String sitesName;//账号 注册登录用

    private String sitesUserName;//用户名称

    private String password;//密码

    private String sitesPhone; //手机号


    private Integer  membersId;//会员Id

    private Integer  status;//审核状态

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Transient
    private String verification;//验证码

    private Integer state;//用于查看账号是否被注销 1正常 0注销

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSitesName() {
        return sitesName;
    }

    public void setSitesName(String sitesName) {
        this.sitesName = sitesName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSitesPhone() {
        return sitesPhone;
    }

    public void setSitesPhone(String sitesPhone) {
        this.sitesPhone = sitesPhone;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getSitesUserName() {
        return sitesUserName;
    }

    public void setSitesUserName(String sitesUserName) {
        this.sitesUserName = sitesUserName;
    }


}
