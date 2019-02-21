package com.lyq.service;

import com.lyq.model.Mold;

import java.util.List;
import java.util.Map;

public interface MoldService {
    //查询所有类型加分页
    Map<String, Object> queryMold(Integer page, Integer rows,Mold mold);
    //删除类型
    void deleteMold(Mold mold);
    //新增类型
    void addMold(Mold mold);
    //修改回显
    Mold queryMoldById(Mold mold);
    //修改类型
    void updateMold(Mold mold);
    //查询所有类型 新增课程使用不分页
    List<Mold> queryMoldByList();
    //柱 折 报表查询
    Map<String, Object> reportsPillar();
    //饼 报表查询
    List<Map<String , Object>> reportsCake();

}
