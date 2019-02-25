package com.lyq.mapper;

import com.lyq.model.SitesUser;
import org.apache.ibatis.annotations.Param;

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

    //查询待审核所有用户
    List<SitesUser> queryCheckUser();
   //查询一个待审核用户信息
   SitesUser queryCheckUserById(Integer id);
  //更改审核状态
    void checkUser(Integer id);

    SitesUser sitesUserLogin(SitesUser user);
}

