package com.lyq.service;

import com.lyq.model.Advertising;
import com.lyq.model.News;
import com.lyq.model.Staff;

import java.util.HashMap;
import java.util.List;

public interface NewsService {
    //查询新闻
    HashMap<String,Object> queryNews(Integer page, Integer rows);

    //新增修改新闻
    void saveNews(News news);

    //回显
    News queryById(Integer id);

    //删除
    void deleteNews(Integer id);

    //查询用户
    List<Staff> queryUser();

}
