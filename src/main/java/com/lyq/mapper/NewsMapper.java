package com.lyq.mapper;

import com.lyq.model.Advertising;
import com.lyq.model.News;
import com.lyq.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    //查询总条数
    long queryNewsTotal();

    //查询新闻
    List<News> queryNews(@Param("start") int start,@Param("rows") Integer rows);

    //修改新闻
    void updateNews(News news);

    //新增新闻
    void saveNews(News news);

    //回显
    News queryById(Integer id);

    //删除
    void deleteNews(Integer id);

    //查询用户
    List<Staff> queryUser();
}
