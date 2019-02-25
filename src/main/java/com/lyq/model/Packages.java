package com.lyq.model;

import javax.persistence.*;

@Entity
@Table(name="t_pa")
public class Packages {
   //套餐表
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pId;   //套餐Id

    private String  pName;//套餐名称

    private Integer  price;//价格

    private Integer  membersId;//会员Id

    @Transient
    private String   membersName;

    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }
}
