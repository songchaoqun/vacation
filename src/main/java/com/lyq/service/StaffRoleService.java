package com.lyq.service;

import com.lyq.model.StaffRole;

import java.util.List;
import java.util.Map;

public interface StaffRoleService {
    //新增员工角色
    void addStaffRole(StaffRole staffRole);
    //删除员工角色
    String deleteStaffRole(StaffRole staffRole);
    //查询角色
    Map<String, Object> queryStaffRoleList(Integer page, Integer rows);
    //查询员工新增页面角色
    List<StaffRole> selectStaffRoleNames();
}
