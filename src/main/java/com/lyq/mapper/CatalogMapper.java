package com.lyq.mapper;

import com.lyq.model.Catalog;

import java.util.List;

public interface CatalogMapper {
    //查询所有目录信息
    List<Catalog> queryCatalog(int i);
    //新增目录信息
    void addCatalog(Catalog catalog);
    //删除目录信息
    void deleteCatalog(List<Integer> arr);
    //查询要删除的目录下的所有子节点
    List<Catalog> queryCatalogList(Integer id);
    //查询主目录
    List<Catalog> queryHostCatalog(int i);
}
