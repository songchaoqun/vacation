package com.lyq.mapper;

import com.lyq.model.Mold;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoldMapper {
    //查询所有类型加分页
    List<Mold> queryMold();
    //删除类型
    void deleteMold(Mold mold);
    //新增类型
    void addMold(Mold mold);
    //修改回显
    Mold queryMoldById(Mold mold);
    //修改类型
    void updateMold(Mold mold);
    //柱 折 报表查询
    List<Mold> reportsPillar();
    //查询所有类型加分页 条查
    List<Mold> queryMoldList(@Param("mold") Mold mold);
}
