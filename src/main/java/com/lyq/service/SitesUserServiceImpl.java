package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.SitesUserMapper;
import com.lyq.model.Mold;
import com.lyq.model.SitesUser;
import com.lyq.utils.CommonCanstant;
import com.lyq.utils.HttpClientUtil;
import com.lyq.utils.MD5Util;
import com.lyq.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<SitesUser> queryCheckUser() {
        return sitesUserMapper.queryCheckUser();
    }

    @Override
    public void checkUser(Integer id) {
        sitesUserMapper.checkUser(id);
        //手机号查询
        SitesUser s=sitesUserMapper.queryCheckUserById(id);
        String phone=s.getSitesPhone();
        if(s.getStatus()==1){
            String url = CommonCanstant.SEND_MSG_URL;
            HashMap<String, Object> params = new HashMap<>();
            params.put("accountSid", CommonCanstant.SEND_MSG_ACCOUNT_ID);//开发者主账号ID
            params.put("to",phone);//短信接收端手机号码集合
            String time = TimeUtil.format(new Date());
            params.put("timestamp",time);//时间戳
            String sigStr = CommonCanstant.SEND_MSG_ACCOUNT_ID+CommonCanstant.SEND_MSG_TOKEN+time;
            params.put("sig", MD5Util.getMd532(sigStr));//签名。MD5(ACCOUNT SID + AUTH TOKEN + timestamp)。共32位（小写）
            params.put("templateid", "1120139740");//短信模板ID
            String seCode= "恭喜审核通过，欢迎成为本站用户哦！";
            params.put("param", seCode+",3");//短信变量
            String post = HttpClientUtil.post(url, params);

        }




    }


}
