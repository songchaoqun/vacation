package com.lyq.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;//主键Id
    private String task_name;//任务名称
    private Integer cre_id;//创建人Id
    private Integer fin_id;//完成人Id
    private Integer status;//状态
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date  cre_time;//创建时间
    @Transient
    private  String	 sdate;
    @Transient
    private  String edate;
    @Transient
    private  String	 cre_name;
    @Transient
    private  String fin_name;

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getCre_name() {
        return cre_name;
    }

    public void setCre_name(String cre_name) {
        this.cre_name = cre_name;
    }

    public String getFin_name() {
        return fin_name;
    }

    public void setFin_name(String fin_name) {
        this.fin_name = fin_name;
    }

    public Date getCre_time() {
        return cre_time;
    }

    public void setCre_time(Date cre_time) {
        this.cre_time = cre_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Integer getCre_id() {
        return cre_id;
    }

    public void setCre_id(Integer cre_id) {
        this.cre_id = cre_id;
    }

    public Integer getFin_id() {
        return fin_id;
    }

    public void setFin_id(Integer fin_id) {
        this.fin_id = fin_id;
    }
}
