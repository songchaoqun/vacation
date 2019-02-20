package com.lyq.controller;

import com.lyq.model.Way;
import com.lyq.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//权限路径控制层
@Controller
@RequestMapping("way")
public class WayController {

    @Autowired
    private WayService wayService;

    //新增权限路径
    @ResponseBody
    @RequestMapping("addWay")
    public void addWay(Way way){
        wayService.addWay(way);
    }

    //删除权限路径
    @ResponseBody
    @RequestMapping("deleteWay")
    public void deleteWay(Way way){
        wayService.deleteWay(way);
    }

    //查询权限路径
    @ResponseBody
    @RequestMapping("queryWayList")
    public List<Way> queryWayList(Integer id){
        return wayService.queryWayList(id);
    }

}
