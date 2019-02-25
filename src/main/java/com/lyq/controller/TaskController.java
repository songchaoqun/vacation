package com.lyq.controller;

import com.lyq.model.Staff;
import com.lyq.model.Task;
import com.lyq.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    //查询任务
    @ResponseBody
    @RequestMapping("queryTask")
    public Map<String , Object>queryTask(Integer page, Integer rows,HttpSession session){
        Staff s= (Staff) session.getAttribute("staff");
        return taskService.queryTask(page,rows,s);
    }
    //查询执行人
    @ResponseBody
    @RequestMapping("queryTaff")
    public List<Staff> queryTaff(HttpSession session){
        Staff s= (Staff) session.getAttribute("staff");
        return taskService.queryTaff(s);
    }
    @ResponseBody
    @RequestMapping("updateStatus")
    public void updateStatus(Integer id){

        taskService.updateStatus(id);
    }
    @ResponseBody
    @RequestMapping("addTask")
    public void addTask(Task t,HttpSession session){
        Staff s= (Staff) session.getAttribute("staff");
        Integer cid=s.getId();

        taskService.addTask(t,cid);
    }
    @ResponseBody
    @RequestMapping("delTask")
    public void delTask(Integer ids){

        taskService.delTask(ids);
    }

}
