package com.lyq.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_mempack")
public class MemPacka {
    //会员用户关系表
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   //中间表Id

    private Integer uid; //用户Id

    private Integer mid; //会员Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate; //注册时间
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date duetoDate; // 到期时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDuetoDate() {
        return duetoDate;
    }

    public void setDuetoDate(Date duetoDate) {
        this.duetoDate = duetoDate;
    }
}
