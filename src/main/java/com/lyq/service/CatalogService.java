package com.lyq.service;

import com.lyq.model.Catalog;

import java.util.List;

public interface CatalogService{
    //查询所有目录信息
    List<Catalog> queryCatalog();
    //新增目录信息
    void addCatalog(Catalog catalog);
    //删除目录信息
    void deleteCatalog(Catalog catalog);
    //查询主目录
    List<Catalog> queryHostCatalog();
}
