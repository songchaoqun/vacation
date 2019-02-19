package com.lyq.controller;

import com.lyq.model.StaffRole;
import com.lyq.service.StaffRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

//员工角色表控制层
@Controller
@RequestMapping("staffRole")
public class StaffRoleController {

    @Autowired
    private StaffRoleService staffRoleService;

    //新增员工角色
    @ResponseBody
    @RequestMapping("addStaffRole")
    public void addStaffRole(StaffRole staffRole){
        staffRoleService.addStaffRole(staffRole);
    }

    //删除员工角色
    @ResponseBody
    @RequestMapping("deleteStaffRole")
    public String deleteStaffRole(StaffRole staffRole){
        return staffRoleService.deleteStaffRole(staffRole);
    }

    //查询角色
    @ResponseBody
    @RequestMapping("queryStaffRoleList")
    public Map<String , Object> queryStaffRoleList(Integer page, Integer rows){
        return staffRoleService.queryStaffRoleList(page,rows);
    }

    //查询员工新增页面角色
    @ResponseBody
    @RequestMapping("selectStaffRoleNames")
    public List<StaffRole> selectStaffRoleNames(){
        return staffRoleService.selectStaffRoleNames();
    }
}
