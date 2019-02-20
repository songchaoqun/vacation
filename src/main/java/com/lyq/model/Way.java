package com.lyq.model;

import javax.persistence.*;

//权限路径表
@Entity
@Table(name="t_way")
public class Way {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //主键Id

    private String name; //功能名称

    private String url; //方法的路径

    private Integer treeId; //关联权限树的Id

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTreeId() {
        return treeId;
    }

    public void setTreeId(Integer treeId) {
        this.treeId = treeId;
    }
}
