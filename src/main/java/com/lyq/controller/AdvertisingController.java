package com.lyq.controller;


import com.lyq.model.Advertising;
import com.lyq.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("advertising")
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    //查询广告
    @ResponseBody
    @RequestMapping("queryAdvertising")
    public HashMap<String , Object> queryAdvertising(Integer page, Integer rows){
        return advertisingService.queryAdvertising(page,rows);
    }

    //新增修改广告
    @RequestMapping("saveAdvertising")
    @ResponseBody
    public void saveAdvertising(Advertising advertising,HttpServletRequest request, MultipartFile file){
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("success", true);
        value.put("errorCode", 0);
        value.put("errorMsg", "");

        String head =  advertisingService.saveAdvertising(advertising,file);
        value.put("data", head);
    }



    //回显
    @RequestMapping("queryById")
    @ResponseBody
    public Advertising queryById(Integer id){
        return advertisingService.queryById(id);
    }

    //删除
    @RequestMapping("deleteAd")
    @ResponseBody
    public void deleteAd(Integer id){
         advertisingService.deleteAd(id);
    }


}
