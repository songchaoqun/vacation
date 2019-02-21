package com.lyq.controller;

import com.lyq.model.Mold;
import com.lyq.service.MoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//类型控制层
@Controller
@RequestMapping("mold")
public class MoldController {

    @Autowired
    private MoldService moldService;

    //查询所有类型 新增课程使用不分页
    @ResponseBody
    @RequestMapping("queryMoldByList")
    public List<Mold> queryMoldByList(){
        return moldService.queryMoldByList();
    }

    //查询所有类型加分页
    @ResponseBody
    @RequestMapping("queryMold")
    public Map<String , Object> queryMold(Integer page, Integer rows,Mold mold){
        return moldService.queryMold(page,rows,mold);
    }

    //删除类型
    @ResponseBody
    @RequestMapping("deleteMold")
    public void deleteMold(Mold mold){
        moldService.deleteMold(mold);
    }

    //新增类型
    @ResponseBody
    @RequestMapping("addMold")
    public void addMold(Mold mold){
        moldService.addMold(mold);
    }

    //修改回显
    @ResponseBody
    @RequestMapping("queryMoldById")
    public Mold queryMoldById(Mold mold){
        return moldService.queryMoldById(mold);
    }

    //修改类型
    @ResponseBody
    @RequestMapping("updateMold")
    public void updateMold(Mold mold){
        moldService.updateMold(mold);
    }

    //柱 折 报表查询
    @ResponseBody
    @RequestMapping("reportsPillar")
    public Map<String , Object> reportsPillar(){
        return moldService.reportsPillar();
    }

    //饼 报表查询
    @ResponseBody
    @RequestMapping("reportsCake")
    public List<Map<String , Object>> reportsCake(){
        return moldService.reportsCake();
    }


}
