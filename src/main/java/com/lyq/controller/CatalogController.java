package com.lyq.controller;


import com.lyq.model.Catalog;
import com.lyq.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//目录控制层
@Controller
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    //查询所有目录信息
    @ResponseBody
    @RequestMapping("queryCatalog")
    public List<Catalog> queryCatalog(){
        return catalogService.queryCatalog();
    }

    //新增目录信息
    @ResponseBody
    @RequestMapping("addCatalog")
    public void addCatalog(Catalog catalog){
       catalogService.addCatalog(catalog);
    }

    //删除目录信息
    @ResponseBody
    @RequestMapping("deleteCatalog")
    public void deleteCatalog(Catalog catalog){
        catalogService.deleteCatalog(catalog);
    }

    //查询主目录
    @ResponseBody
    @RequestMapping("queryHostCatalog")
    public List<Catalog> queryHostCatalog(){
        return catalogService.queryHostCatalog();
    }
}
