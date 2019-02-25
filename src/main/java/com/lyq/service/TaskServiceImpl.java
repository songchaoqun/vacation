package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.AnswerMapper;
import com.lyq.mapper.TaskMapper;
import com.lyq.model.Answer;
import com.lyq.model.Staff;
import com.lyq.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;


    @Override
    public Map<String, Object> queryTask(Integer page, Integer rows, Staff s) {
        Page<Task> pageHelper = PageHelper.startPage(page, rows);
        List<Task> queryMoleList = taskMapper.queryTask(s.getId());
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    @Override
    public List<Staff> queryTaff(Staff s) {
        return taskMapper.queryTaff(s.getId());
    }

    @Override
    public void updateStatus(Integer id) {
        taskMapper.updateStatus(id);
    }

    @Override
    public void addTask(Task t,Integer cid) {
        taskMapper.addTask( t,cid);
    }

    @Override
    public void delTask(Integer ids) {
        taskMapper.delTask(ids);

    }
}
