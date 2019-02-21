package com.lyq.service;

import com.lyq.model.Staff;
import com.lyq.model.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    Map<String,Object> queryTask(Integer page, Integer rows, Staff s);

    List<Staff> queryTaff(Staff s);

    void updateStatus(Integer id);

    void addTask(Task t,Integer cid);

    void delTask(Integer ids);
}
