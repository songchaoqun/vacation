package com.lyq.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import java.text.DateFormat;
import java.util.Date;

//日志表
@Document(collection="way_log")
public class Log {

    private Integer userId;

    @Transient
    private String startDate;

    @Transient
    private String endDate;
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String className;

    /**
     *
     */
    private String method;

    /**
     *
     */
    private String reqParam;

    /**
     *
     */
    private String respParam;

    /**
     * 访问的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * Ip用于请求的Ip
     */
    private String ip;

    /**
     * 浏览的地址路径
     */
    private String url;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }

    public String getRespParam() {
        return respParam;
    }

    public void setRespParam(String respParam) {
        this.respParam = respParam;
    }

    public String getCreateTime() {
        String  s = DateFormat.getDateInstance().format(createTime);
        return s;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
