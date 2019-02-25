package com.lyq.service;

import com.lyq.mapper.NewsMapper;
import com.lyq.model.Advertising;
import com.lyq.model.News;
import com.lyq.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsMapper newsMapper;

    //查询新闻
    @Override
    public HashMap<String, Object> queryNews(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = newsMapper.queryNewsTotal();
        //查询显示信息
        //开始位置
        int start = (page-1)*rows;
        List<News> list =  newsMapper.queryNews(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    //新增修改
    @Override
    public void saveNews(News news) {
        Integer id = news.getId();
        if(id!=null) {
            //修改广告
            newsMapper.updateNews(news);
        }else {
            //新增广告
            newsMapper.saveNews(news);
        }
    }

    //回显
    @Override
    public News queryById(Integer id) {

        News news= newsMapper.queryById(id);
        return news;
    }

    //删除
    @Override
    public void deleteNews(Integer id) {
        newsMapper.deleteNews(id);

    }

    //查询用户
    @Override
    public List<Staff> queryUser() {
        return newsMapper.queryUser();
    }
}
