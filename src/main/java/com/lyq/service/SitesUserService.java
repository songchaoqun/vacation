package com.lyq.service;

import com.lyq.model.SitesUser;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface SitesUserService {
    //查询网站用户列表 并分页
    Map<String, Object> querySitesUser(Integer page, Integer rows);
    //新增网站用户
    void addSitesUser(SitesUser sitesUser);
    //删除网站用户 逻辑删
    void deleteSitesUser(SitesUser sitesUser);
    //修改回显
    SitesUser querySitesUserList(SitesUser sitesUser);
    //修改网站用户
    void updateSitesUser(SitesUser sitesUser);
    //回收站 查询被删除的网站用户
    Map<String, Object> queryRecycleSitesUser(Integer page, Integer rows);
    //查询所有正常用户
    List<SitesUser> queryCommentSitesUser();

    //查询待审核用户
    List<SitesUser> queryCheckUser();
    //审核通过
    void checkUser(Integer id);


    String sitesUserLogin(SitesUser user, HttpSession session);
}
