package com.lyq.mapper;

import com.lyq.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {
    //新增员工信息
    void addStaff(Staff staff);
    //新增中间关联表
    void addStaffRole(@Param("id") Integer id, @Param("split")String[] split);
    //删除员工信息
    void deleteStaff(Integer id);
    //查询员工信息
    List<Staff> queryStaffList(@Param("staff")Staff staff);
    //删除和这个id绑定的角色信息
    void deleteStaffRole(Integer id);
    //查询该用户是否存在
    Staff staffLogin(Staff staff);
}
