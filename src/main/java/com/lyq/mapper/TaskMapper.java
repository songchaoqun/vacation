package com.lyq.mapper;

import com.lyq.model.Staff;
import com.lyq.model.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskMapper {
    //查询
    List<Task> queryTask(Integer id);

    List<Staff> queryTaff(Integer id);

    void updateStatus(Integer id);

    void addTask(@Param("t") Task t, @Param("cid") Integer cid);

    void delTask(Integer ids);
}
