package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.CourserMapper;
import com.lyq.model.Course;
import com.lyq.model.Mold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourserServiceImpl implements CourserService{

    @Autowired
    private CourserMapper courserMapper;

    //新增课程
    public void addCourse(Course course) {
        courserMapper.addCourse(course);
    }

    //删除课程
    public void deleteCourse(Course course) {
        courserMapper.deleteCourse(course);
    }

    //查询课程
    public Map<String, Object> queryCourse(Integer page, Integer rows) {
        Page<Course> pageHelper = PageHelper.startPage(page, rows);
        List<Course> queryMoleList = courserMapper.queryCourse();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //课程回显
    public Course queryCourseById(Course course) {
        return courserMapper.queryCourseById(course);
    }

    //修改课程
    public void updateCourse(Course course) {
        courserMapper.updateCourse(course);
    }

    //查询所有课程
    public List<Course> queryCourseList() {
        return courserMapper.queryCourseList();
    }
}
