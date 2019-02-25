package com.lyq.controller;

import com.lyq.model.Advertising;
import com.lyq.model.News;
import com.lyq.model.Staff;
import com.lyq.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    //查询新闻
    @ResponseBody
    @RequestMapping("queryNews")
    public HashMap<String , Object> queryNews(Integer page, Integer rows){
          //Staff staff= (Staff) session.getAttribute("staff");
        return newsService.queryNews(page,rows);
    }

    //查询用户
    @ResponseBody
    @RequestMapping("queryUser")
    public List<Staff> queryUser(){
        return newsService.queryUser();
    }

    //新增修改新闻
    @RequestMapping("saveNews")
    @ResponseBody
    public void saveNews(News news){
        newsService.saveNews(news);
    }

    //回显
    @RequestMapping("queryById")
    @ResponseBody
    public News queryById(Integer id){
        return newsService.queryById(id);
    }

    //删除
    @RequestMapping("deleteNews")
    @ResponseBody
    public void deleteNews(Integer id){
        newsService.deleteNews(id);
    }

}
