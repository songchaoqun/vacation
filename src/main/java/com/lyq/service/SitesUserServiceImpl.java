package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.SitesUserMapper;
import com.lyq.model.Mold;
import com.lyq.model.SitesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SitesUserServiceImpl implements SitesUserService{

    @Autowired
    private SitesUserMapper sitesUserMapper;

    //查询网站用户列表 并分页
    public Map<String, Object> querySitesUser(Integer page, Integer rows) {
        Page<SitesUser> pageHelper = PageHelper.startPage(page, rows);
        List<SitesUser> queryMoleList = sitesUserMapper.querySitesUser();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //新增网站用户
    public void addSitesUser(SitesUser sitesUser) {
        sitesUserMapper.addSitesUser(sitesUser);
    }

    //删除网站用户 逻辑删
    public void deleteSitesUser(SitesUser sitesUser) {
        sitesUserMapper.deleteSitesUser(sitesUser);
    }

    //修改回显
    public SitesUser querySitesUserList(SitesUser sitesUser) {
        return sitesUserMapper.querySitesUserList(sitesUser);
    }

    //修改网站用户
    public void updateSitesUser(SitesUser sitesUser) {
        sitesUserMapper.updateSitesUser(sitesUser);
    }

    //回收站 查询被删除的网站用户
    public Map<String, Object> queryRecycleSitesUser(Integer page, Integer rows) {
        Page<SitesUser> pageHelper = PageHelper.startPage(page, rows);
        List<SitesUser> queryMoleList = sitesUserMapper.queryRecycleSitesUser();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //查询所有正常用户
    public List<SitesUser> queryCommentSitesUser() {
        return sitesUserMapper.querySitesUser();
    }
}
