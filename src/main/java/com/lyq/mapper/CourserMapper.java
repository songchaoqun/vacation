package com.lyq.mapper;

import com.lyq.model.Course;

import java.util.List;

public interface CourserMapper {
    //新增课程
    void addCourse(Course course);
    //删除课程
    void deleteCourse(Course course);
    //查询课程
    List<Course> queryCourse();
    //课程回显
    Course queryCourseById(Course course);
    //修改课程
    void updateCourse(Course course);
    //查询所有课程
    List<Course> queryCourseList();
}
