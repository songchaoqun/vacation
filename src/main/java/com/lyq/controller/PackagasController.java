package com.lyq.controller;

import com.lyq.model.Packages;
import com.lyq.service.MembersService;
import com.lyq.service.PackagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("pack")
public class PackagasController {

    @Autowired
    private PackagasService packagasService;

    @RequestMapping("queryPackages")
    @ResponseBody
    public List<Packages> queryPackages(){

        return packagasService.queryPackages();
    }
}
