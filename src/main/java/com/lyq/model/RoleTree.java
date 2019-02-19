package com.lyq.model;

import javax.persistence.*;

@Entity
@Table(name="t_role_tree")
public class RoleTree {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //目录表主键Id

    private Integer treeId;//权限id

    private Integer roleId;//角色id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
