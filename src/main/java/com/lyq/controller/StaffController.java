package com.lyq.controller;

import com.lyq.model.Staff;
import com.lyq.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

//员工表控制层
@Controller
@RequestMapping("staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    //新增员工信息
    @ResponseBody
    @RequestMapping("addStaff")
    public void addStaff(Staff staff){
        staffService.addStaff(staff);
    }

    //删除员工信息
    @ResponseBody
    @RequestMapping("deleteStaff")
    public void deleteStaff(Staff staff){
        staffService.deleteStaff(staff);
    }

    //查询员工信息
    @ResponseBody
    @RequestMapping("queryStaffList")
    public Map<String ,Object> queryStaffList(Integer page, Integer rows){
       return staffService.queryStaffList(page,rows);
    }

    //员工登录
    @ResponseBody
    @RequestMapping("staffLogin")
    public String staffLogin(Staff staff, HttpSession session){
        return staffService.staffLogin(staff,session);
    }

}
