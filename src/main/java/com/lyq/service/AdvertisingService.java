package com.lyq.service;

import com.lyq.model.Advertising;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public interface AdvertisingService {
    //查询广告
    HashMap<String,Object> queryAdvertising(Integer page, Integer rows);

    //新增修改广告
    String saveAdvertising(Advertising advertising, MultipartFile file);

    //回显
    Advertising queryById(Integer id);

    //删除
    void deleteAd(Integer id);
}