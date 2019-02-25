package com.lyq.mapper;

import com.lyq.model.Advertising;
import com.lyq.model.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisingMapper {

    //广告总条数
    long queryAdvertisingTotal();

     //广告查询
    List<Advertising> queryAdvertising(@Param("start") int start, @Param("rows")Integer rows);

    //新增广告
    void saveAdvertising(Advertising advertising);

    //回显
    Advertising queryById(Integer id);

    //修改
    void updateAdvertising(Advertising advertising);

    //删除
    void deleteAd(Integer id);
}
