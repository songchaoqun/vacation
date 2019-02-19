package com.lyq.model;

import javax.persistence.*;

//类型表
@Entity
@Table(name="t_mold")
public class Mold {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //类型主键Id

    private String name;//类型名称

    @Transient
    private String reports; //报表数量

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
