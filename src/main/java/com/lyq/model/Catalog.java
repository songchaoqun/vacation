package com.lyq.model;

import javax.persistence.*;
import java.util.List;

//课程目录表
@Entity
@Table(name="t_catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //目录表主键Id

    private Integer pid;//绑定和他对应的课程目录和和第一章下的数据

    private String moldName;//目录名称

    private String moldUrl;//目录下的视频跳转路径

    private Integer courseId;//绑定对应的课程用来查询

    @Transient
    private List<Catalog> children; //递归查询目录

    @Transient
    //显示课程名称
    private String courseName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMoldName() {
        return moldName;
    }

    public void setMoldName(String moldName) {
        this.moldName = moldName;
    }

    public String getMoldUrl() {
        return moldUrl;
    }

    public void setMoldUrl(String moldUrl) {
        this.moldUrl = moldUrl;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Catalog> getChildren() {
        return children;
    }

    public void setChildren(List<Catalog> children) {
        this.children = children;
    }
}
