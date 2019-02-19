package com.lyq.model;

import javax.persistence.*;

//员工角色表
@Entity
@Table(name="t_staff_role")
public class StaffRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //员工角色表主键Id

    private String name;//员工角色名称

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
