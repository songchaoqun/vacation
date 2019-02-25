package com.lyq.service;

import com.lyq.mapper.AdvertisingMapper;
import com.lyq.model.Advertising;
import com.lyq.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService{

    @Autowired
    private AdvertisingMapper advertisingMapper;

    @Autowired
    private OSSClientUtil ossClient;

    //查询广告
    @Override
    public HashMap<String, Object> queryAdvertising(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = advertisingMapper.queryAdvertisingTotal();
        //查询显示信息
        //开始位置
        int start = (page-1)*rows;
        List<Advertising> list = advertisingMapper.queryAdvertising(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    //新增修改广告
    @Override
    public String saveAdvertising(Advertising advertising, MultipartFile file) {

        if (file == null || file.getSize() <= 0) {
            System.out.println("头像不能为空");
        }
        String name = ossClient.uploadImg2Oss(file);

        String imgUrl = ossClient.getImgUrl(name);



        Integer id = advertising.getId();
        if(id!=null) {
                advertising.setImg(imgUrl);
        //修改广告
        advertisingMapper.updateAdvertising(advertising);
    }else {
        //新增广告
            advertising.setImg(imgUrl);
        advertisingMapper.saveAdvertising(advertising);
    }
        return imgUrl;
}

    //回显
    @Override
    public Advertising queryById(Integer id) {
        return advertisingMapper.queryById(id);
    }

    //删除
    @Override
    public void deleteAd(Integer id) {
        advertisingMapper.deleteAd(id);
    }


}
