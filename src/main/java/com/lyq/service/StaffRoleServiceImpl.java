package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.StaffRoleMapper;
import com.lyq.model.RoleStaff;
import com.lyq.model.Staff;
import com.lyq.model.StaffRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffRoleServiceImpl implements StaffRoleService{

    @Autowired
    private StaffRoleMapper staffRoleMapper;

    //新增员工角色
    @Override
    public void addStaffRole(StaffRole staffRole) {
        staffRoleMapper.addStaffRole(staffRole);
    }

    //删除员工角色
    @Override
    public String deleteStaffRole(StaffRole staffRole) {
        //先查询该角色有没有被使用 被使用不可删除
        List<RoleStaff> roleList = staffRoleMapper.queryRoleStaff(staffRole.getId());
        if(roleList.size() > 0){
            //0 被使用不可删除
            return "0";
        }
        //删除该角色绑定的权限
        staffRoleMapper.deleteTreeRole(staffRole.getId());
        staffRoleMapper.deleteStaffRole(staffRole.getId());
        return "1";
    }

    //查询角色
    @Override
    public Map<String, Object> queryStaffRoleList(Integer page, Integer rows) {
        Page<StaffRole> pageHelper = PageHelper.startPage(page, rows);
        List<StaffRole> queryUserList = staffRoleMapper.queryStaffRoleList();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryUserList);
        return dataMap;
    }

    //查询员工新增页面角色
    @Override
    public List<StaffRole> selectStaffRoleNames() {
        return staffRoleMapper.queryStaffRoleList();
    }
}
