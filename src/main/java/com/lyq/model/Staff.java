package com.lyq.model;

import javax.persistence.*;

//员工表
@Entity
@Table(name="t_staff")
public class Staff {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //员工表主键Id

    private String staffName;//员工账号

    private String password;//员工密码

    @Transient
    private String roleIds;//角色id用于两表新增

    @Transient
    private String verification;//验证码

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
