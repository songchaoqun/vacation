package com.lyq.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

//问题表
@Entity
@Table(name="t_problem")
public class Problem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //问题表主键Id

    private String problemName;//提出的问题

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date problemCreateTime;//问题的创建时间

    private Integer hottest;//是否为热门 1是 0不是

    private Integer sitesId; //提出问题的id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public Date getProblemCreateTime() {
        return problemCreateTime;
    }

    public void setProblemCreateTime(Date problemCreateTime) {
        this.problemCreateTime = problemCreateTime;
    }

    public Integer getHottest() {
        return hottest;
    }

    public void setHottest(Integer hottest) {
        this.hottest = hottest;
    }

    public Integer getSitesId() {
        return sitesId;
    }

    public void setSitesId(Integer sitesId) {
        this.sitesId = sitesId;
    }
}
