package com.lyq.service;

import com.lyq.mapper.WayMapper;
import com.lyq.model.Way;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayServiceImpl implements WayService{

    @Autowired
    private WayMapper wayMapper;

    //新增权限路径
    public void addWay(Way way) {
        wayMapper.addWay(way);
    }

    //删除权限路径
    public void deleteWay(Way way) {
        wayMapper.deleteWay(way);
    }

    //查询权限路径
    public List<Way> queryWayList(Integer id) {
        return wayMapper.queryWayList(id);
    }
}
