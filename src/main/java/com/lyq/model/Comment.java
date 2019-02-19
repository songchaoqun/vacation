package com.lyq.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

//评论表
@Entity
@Table(name="t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //评论表主键Id

    private Integer sitesId;//用户评论id

    private Integer catalogId;//评论的课程id

    private String content;//评论内容

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date commentTime;//评论创建时间

    private Integer status;//评论的状态 0存在 1不存在

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSitesId() {
        return sitesId;
    }

    public void setSitesId(Integer sitesId) {
        this.sitesId = sitesId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
