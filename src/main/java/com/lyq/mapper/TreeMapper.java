package com.lyq.mapper;

import com.lyq.model.RoleTree;
import com.lyq.model.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeMapper {
    //查询页面树
    List<Tree> queryTreeList(Integer id);
    //角色拥有的权限
    List<RoleTree> queryRoleList(Integer id);
    //新增权限树
    void addTree(Tree tree);
    //查看该权限是否让选中
    Long queryRoleTree(List<Integer> arr);
    //删除选中的节点 包含他下面的子节点
    void deleteTreeById(List<Integer> arr);
    //绑定角色权限
    void addRoleTree(@Param("id") Integer id, @Param("split") List<Integer> split);
    //删除原有的权限
    void deleteTreeRoleId(Integer id);
    //查询当前ID下的自己的父级id
    List<Tree> queryTreeRoleList(@Param("id")String treeRoleIds);
    //查询当前ID下的上级id
    List<Tree> queryRoleTreePids(@Param("id")List<Tree> treeList);
}
