package com.lyq.controller;

import com.lyq.model.Staff;
import com.lyq.model.StaffRole;
import com.lyq.model.Tree;
import com.lyq.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

//权限表控制层 页面树
@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    //查询页面树
    @ResponseBody
    @RequestMapping("queryTreeList")
    public List<Tree> queryTreeList(HttpSession session){
        Staff staff = (Staff)session.getAttribute("staff");
        return treeService.queryTreeList(staff);
    }

    //页面的权限树
    @ResponseBody
    @RequestMapping("queryRoleTreeList")
    public List<Tree> queryRoleTreeList(StaffRole staffRole){
        return treeService.queryRoleTreeList(staffRole);
    }

    //新增权限树
    @ResponseBody
    @RequestMapping("addTree")
    public void addTree(Tree tree){
        treeService.addTree(tree);
    }

    //删除权限树
    @ResponseBody
    @RequestMapping("deleteTree")
    public String deleteTree(Tree tree){
        return treeService.deleteTree(tree);
    }

    //绑定角色权限
    @ResponseBody
    @RequestMapping("addRoleTree")
    public String addRoleTree(Integer id,String treeRoleIds){
        return treeService.addRoleTree(id,treeRoleIds);
    }
}
