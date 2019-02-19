package com.lyq.service;

import com.lyq.model.Staff;
import com.lyq.model.StaffRole;
import com.lyq.model.Tree;

import java.util.List;

public interface TreeService {
    //查询页面树
    List<Tree> queryTreeList(Staff staff);
    //页面的权限树
    List<Tree> queryRoleTreeList(StaffRole staffRole);
    //新增权限树
    void addTree(Tree tree);
    //删除权限树
    String deleteTree(Tree tree);
    //绑定角色权限
    String addRoleTree(Integer id, String treeRoleIds);
}
