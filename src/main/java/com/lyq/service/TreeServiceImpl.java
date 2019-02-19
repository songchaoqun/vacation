package com.lyq.service;

import com.lyq.mapper.TreeMapper;
import com.lyq.model.RoleTree;
import com.lyq.model.Staff;
import com.lyq.model.StaffRole;
import com.lyq.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService{

    @Autowired
    private TreeMapper treeMapper;

    //查询页面树
    @Override
    public List<Tree> queryTreeList(Staff staff) {
        return queryAscTree(-1);
    }
    public List<Tree> queryAscTree(Integer id){
        List<Tree> tree = treeMapper.queryTreeList(id);
        for (Tree tr:tree){
            tr.setChildren(queryAscTree(tr.getId()));
        }
        return  tree;
    }

    //页面的权限树
    @Override
    public List<Tree> queryRoleTreeList(StaffRole staffRole) {
        if(staffRole.getId() == -1){
            return queryAscTree(-1);
        }
        //角色拥有的权限
        List<RoleTree> roleList = treeMapper.queryRoleList(staffRole.getId());
        return queryRoleTreeListState(-1,roleList);
    }
    private List<Tree> queryRoleTreeListState(int id, List<RoleTree> roleList) {
        List<Tree> tree = treeMapper.queryTreeList(id);
        for (Tree tr:tree){
            for(RoleTree re:roleList){
                if(tr.getId() == re.getTreeId() && tr.getPid() != -1){
                    tr.setChecked(true);
                }
            }
            tr.setChildren(queryRoleTreeListState(tr.getId(),roleList));
        }
        return tree;
    }

    //新增权限树
    @Override
    public void addTree(Tree tree) {
        if(tree.getPid() == null){
            tree.setPid(-1);
        }
        treeMapper.addTree(tree);
    }

    //删除权限树
    @Override
    public String deleteTree(Tree tree) {
        //创建一个list将这个nav.getId()这个id下的所有数据都存放到arr当中然后删除 做到删除一个父节点子节点一并删除
        List<Integer> arr = new ArrayList<>();
        arr.add(tree.getId());
        deleteTreeByIds(tree.getId(),arr);
        //通过list内存地址中的数据去查询中间表 查看该权限是否让选中
        Long count = treeMapper.queryRoleTree(arr);
        //count 等于0的时候删除所选中权限及其子节点
        if(count == 0) {
            treeMapper.deleteTreeById(arr);
            return "1";
        }
        return "0";
    }
    private void deleteTreeByIds(Integer id, List<Integer> arr) {
        List<Tree> tree = treeMapper.queryTreeList(id);
        for (Tree tr:tree){
            arr.add(tr.getId());
            deleteTreeByIds(tr.getId(),arr);
        }
    }

    //绑定角色权限
    @Override
    public String addRoleTree(Integer id, String treeRoleIds) {
        //删除原有的权限
        treeMapper.deleteTreeRoleId(id);
        if(StringUtils.isEmpty(treeRoleIds)){
            return "1";
        }
        //用来将所有的数据放入然后判断添加子节点的根节点
        List<Integer> arr = new ArrayList<>();
        String[] split = treeRoleIds.split(",");
        for (int i = 0;i<split.length;i++){
            arr.add(Integer.parseInt(split[i]));
        }
        //查询当前ID下的上级id
        List<Tree> treeList = treeMapper.queryTreeRoleList(treeRoleIds);
        queryRoleTreePid(treeList,arr);
        treeMapper.addRoleTree(id,arr);
        return "1";
    }
    private void queryRoleTreePid(List<Tree> treeList, List<Integer> arr) {
        List<Tree> tree = treeMapper.queryRoleTreePids(treeList);
        for (Tree tr:tree){
            if(!arr.contains(tr.getPid())){
                arr.add(tr.getPid());
            }
        }
    }
}
