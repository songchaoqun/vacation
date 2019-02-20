package com.lyq.service;

import com.lyq.model.Staff;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface StaffService {
    //新增员工信息
    void addStaff(Staff staff);
    //删除员工信息
    void deleteStaff(Staff staff);
    //查询员工信息
    Map<String, Object> queryStaffList(Integer page, Integer rows,Staff staff);
    //员工登录
    String staffLogin(Staff staff, HttpSession session);
}
