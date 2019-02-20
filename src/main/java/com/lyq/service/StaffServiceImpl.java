package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.StaffMapper;
import com.lyq.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffMapper staffMapper;

    //新增员工信息 以及员工角色中间表
    @Override
    public void addStaff(Staff staff) {
        staffMapper.addStaff(staff);
        //新增中间表
        staffMapper.addStaffRole(staff.getId(),staff.getRoleIds().split(","));
    }

    //删除员工信息
    @Override
    public void deleteStaff(Staff staff) {
        staffMapper.deleteStaff(staff.getId());
        //删除和这个id绑定的角色信息
        staffMapper.deleteStaffRole(staff.getId());
    }

    //查询员工信息
    @Override
    public Map<String, Object> queryStaffList(Integer page, Integer rows,Staff staff) {
        Page<Staff> pageHelper = PageHelper.startPage(page, rows);
        List<Staff> queryUserList = staffMapper.queryStaffList(staff);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryUserList);
        return dataMap;
    }

    public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//放到session中的key

    //员工登录
    public String staffLogin(Staff staff, HttpSession session) {
        String randomcodekey = (String) session.getAttribute(RANDOMCODEKEY);
        if(staff.getVerification().equals(randomcodekey)){
            Staff s = staffMapper.staffLogin(staff);
            if(s != null){
                if(s.getStaffName().equals(staff.getStaffName())){
                    if(s.getPassword().equals(staff.getPassword())){
                        session.setAttribute("staff",staff);
                        return "1";
                    }
                    return "2";
                }
                return "2";
            }
            return "2";
        }
        return "3";
    }
}
