package com.lyq.service;

import com.lyq.model.Way;

import java.util.List;

public interface WayService {
    //新增权限路径
    void addWay(Way way);
    //删除权限路径
    void deleteWay(Way way);
    //查询权限路径
    List<Way> queryWayList(Integer id);
}
