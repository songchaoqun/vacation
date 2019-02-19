package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.MoldMapper;
import com.lyq.model.Mold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoldServiceImpl implements MoldService{

    @Autowired
    private MoldMapper moldMapper;

    //查询所有类型加分页
    public Map<String, Object> queryMold(Integer page, Integer rows) {
        Page<Mold> pageHelper = PageHelper.startPage(page, rows);
        List<Mold> queryMoleList = moldMapper.queryMold();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //删除类型
    public void deleteMold(Mold mold) {
        moldMapper.deleteMold(mold);
    }

    //新增类型
    public void addMold(Mold mold) {
        moldMapper.addMold(mold);
    }

    //修改回显
    public Mold queryMoldById(Mold mold) {
        return moldMapper.queryMoldById(mold);
    }

    //修改类型
    public void updateMold(Mold mold) {
        moldMapper.updateMold(mold);
    }

    //查询所有类型 新增课程使用不分页
    public List<Mold> queryMoldByList() {
        return moldMapper.queryMold();
    }

    //柱 折 报表查询
    public Map<String, Object> reportsPillar() {
        Map<String, Object> moldMap = new HashMap<String, Object>();
        List<Mold> moldList = moldMapper.reportsPillar();
        moldMap.put("container", moldList.stream().map(Mold::getName));
        moldMap.put("data", moldList.stream().map(Mold::getReports));
        return moldMap;
    }

    //饼 报表查询
    public List<Map<String , Object>> reportsCake() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Mold> moldList = moldMapper.reportsPillar();
        for (int i = 0;i < moldList.size();i++){
            Map<String, Object> moldMap = new HashMap<String, Object>();
            moldMap.put("name", moldList.get(i).getName());
            moldMap.put("value", moldList.get(i).getReports());
            list.add(moldMap);
        }
        return list;
    }
}
