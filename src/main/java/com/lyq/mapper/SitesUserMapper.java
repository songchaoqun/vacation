package com.lyq.mapper;

import com.lyq.model.SitesUser;

import java.util.List;

public interface SitesUserMapper {
    //查询网站用户列表 并分页
    List<SitesUser> querySitesUser();
    //新增网站用户
    void addSitesUser(SitesUser sitesUser);
    //删除网站用户 逻辑删
    void deleteSitesUser(SitesUser sitesUser);
    //修改回显
    SitesUser querySitesUserList(SitesUser sitesUser);
    //修改网站用户
    void updateSitesUser(SitesUser sitesUser);
    //回收站 查询被删除的网站用户
    List<SitesUser> queryRecycleSitesUser();
}
