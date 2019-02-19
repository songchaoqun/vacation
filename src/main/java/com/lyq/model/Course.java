package com.lyq.model;

import javax.persistence.*;

//课程表
@Entity
@Table(name="t_course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //课程主键Id

    private String cover; //课程封面

    private Integer mold; //课程类型

    @Transient
    //显示类型名称
    private String moldName;

    private String content;//课程标题

    private String browse;//浏览数

    private String category;//类别

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getMold() {
        return mold;
    }

    public void setMold(Integer mold) {
        this.mold = mold;
    }

    public String getMoldName() {
        return moldName;
    }

    public void setMoldName(String moldName) {
        this.moldName = moldName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBrowse() {
        return browse;
    }

    public void setBrowse(String browse) {
        this.browse = browse;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
