package com.lyq.service;

import com.lyq.mapper.CatalogMapper;
import com.lyq.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private CatalogMapper catalogMapper;

    //查询所有目录信息
    public List<Catalog> queryCatalog() {
        return queryCatalogList(-1);
    }

    private List<Catalog> queryCatalogList(int i) {
        List<Catalog> menuTreeList = catalogMapper.queryCatalog(i);
        for (Catalog menuTree : menuTreeList) {
            menuTree.setChildren(queryCatalogList(menuTree.getId()));
        }
        return menuTreeList;
    }

    //新增目录信息
    public void addCatalog(Catalog catalog) {
        if(catalog.getPid() == null){
            catalog.setPid(-1);
        }
        catalogMapper.addCatalog(catalog);
    }

    //删除目录信息
    public void deleteCatalog(Catalog catalog) {
        //创建一个list将这个nav.getId()这个id下的所有数据都存放到arr当中然后删除 做到删除一个父节点子节点一并删除
        List<Integer> arr = new ArrayList<>();
        arr.add(catalog.getId());
        deleteCatalogByIds(catalog.getId(),arr);
        catalogMapper.deleteCatalog(arr);
    }
    private void deleteCatalogByIds(Integer id, List<Integer> arr) {
        List<Catalog> tree = catalogMapper.queryCatalogList(id);
        for (Catalog tr:tree){
            arr.add(tr.getId());
            deleteCatalogByIds(tr.getId(),arr);
        }
    }

    //查询主目录
    public List<Catalog> queryHostCatalog() {
        return catalogMapper.queryHostCatalog(-1);
    }
}
