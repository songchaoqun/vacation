package com.lyq.mapper;

import com.lyq.model.RoleStaff;
import com.lyq.model.StaffRole;

import java.util.List;

public interface StaffRoleMapper {
    //新增员工角色
    void addStaffRole(StaffRole staffRole);
    //先查询该角色有没有被使用 被使用不可删除
    List<RoleStaff> queryRoleStaff(Integer id);
    //删除员工角色
    void deleteStaffRole(Integer id);
    //查询角色
    List<StaffRole> queryStaffRoleList();
    //删除该角色绑定的权限
    void deleteTreeRole(Integer id);
}
