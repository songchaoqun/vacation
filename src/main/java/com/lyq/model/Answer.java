package com.lyq.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

//答案表
@Entity
@Table(name="t_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //答案表主键Id

    private String answerContent;//答案内容

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date answerCreateTime;//回答时间

    private Integer sitesId; //回答问题的用户id

    private Integer problemId;//关联问题表的Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getAnswerCreateTime() {
        return answerCreateTime;
    }

    public void setAnswerCreateTime(Date answerCreateTime) {
        this.answerCreateTime = answerCreateTime;
    }

    public Integer getSitesId() {
        return sitesId;
    }

    public void setSitesId(Integer sitesId) {
        this.sitesId = sitesId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }
}
