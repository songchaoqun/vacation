package com.lyq.controller;

import com.lyq.model.Course;
import com.lyq.service.CourserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

//课程控制层
@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourserService courserService;

    //新增课程
    @ResponseBody
    @RequestMapping("addCourse")
    public void addCourse(Course course){
        courserService.addCourse(course);
    }

    //删除课程
    @ResponseBody
    @RequestMapping("deleteCourse")
    public void deleteCourse(Course course){
        courserService.deleteCourse(course);
    }

    //查询课程
    @ResponseBody
    @RequestMapping("queryCourse")
    public Map<String , Object> queryCourse(Integer page, Integer rows){
        return courserService.queryCourse(page,rows);
    }

    //课程回显
    @ResponseBody
    @RequestMapping("queryCourseById")
    public Course queryCourseById(Course course){
        return courserService.queryCourseById(course);
    }

    //修改课程
    @ResponseBody
    @RequestMapping("updateCourse")
    public void updateCourse(Course course){
        courserService.updateCourse(course);
    }

    //查询所有课程
    @ResponseBody
    @RequestMapping("queryCourseList")
    public List<Course> queryCourseList(){
        return courserService.queryCourseList();
    }
}
