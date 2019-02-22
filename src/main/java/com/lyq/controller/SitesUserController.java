package com.lyq.controller;

import com.lyq.model.SitesUser;
import com.lyq.service.SitesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//网站用户登录控制层
@Controller
@RequestMapping("sitesUser")
public class SitesUserController {

    @Autowired
    private SitesUserService sitesUserService;

    //查询网站用户列表 并分页
    @ResponseBody
    @RequestMapping("querySitesUser")
    public Map<String , Object> querySitesUser(Integer page, Integer rows){
        return sitesUserService.querySitesUser(page,rows);
    }

    //员工登录
    @ResponseBody
    @RequestMapping("sitesUserLogin")
    public String sitesUserLogin(SitesUser user, HttpSession session){
        return sitesUserService.sitesUserLogin(user,session);
    }


    //新增网站用户
    @ResponseBody
    @RequestMapping("addSitesUser")
    public void addSitesUser(SitesUser sitesUser){
        sitesUserService.addSitesUser(sitesUser);
    }

    //删除网站用户 逻辑删
    @ResponseBody
    @RequestMapping("deleteSitesUser")
    public void deleteSitesUser(SitesUser sitesUser){
        sitesUserService.deleteSitesUser(sitesUser);
    }

    //修改回显
    @ResponseBody
    @RequestMapping("querySitesUserList")
    public SitesUser querySitesUserList(SitesUser sitesUser){
        return sitesUserService.querySitesUserList(sitesUser);
    }

    //修改网站用户
    @ResponseBody
    @RequestMapping("updateSitesUser")
    public void updateSitesUser(SitesUser sitesUser){
        sitesUserService.updateSitesUser(sitesUser);
    }

    //回收站 查询被删除的网站用户
    @ResponseBody
    @RequestMapping("queryRecycleSitesUser")
    public Map<String , Object> queryRecycleSitesUser(Integer page, Integer rows){
        return sitesUserService.queryRecycleSitesUser(page,rows);
    }

    //查询所有正常用户
    @ResponseBody
    @RequestMapping("queryCommentSitesUser")
    public List<SitesUser> queryCommentSitesUser(){
        return sitesUserService.queryCommentSitesUser();
    }
}
