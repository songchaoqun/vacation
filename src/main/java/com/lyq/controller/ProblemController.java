package com.lyq.controller;

import com.lyq.model.Problem;
import com.lyq.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//问题控制层
@Controller
@RequestMapping("problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    //查询所有问题
    @ResponseBody
    @RequestMapping("queryProblem")
    public Map<String , Object> queryProblem(Integer page, Integer rows){
        return problemService.queryProblem(page,rows);
    }

    //新增问题
    @ResponseBody
    @RequestMapping("addProblem")
    public void addProblem(Problem problem){
        problemService.addProblem(problem);
    }

    //删除问题
    @ResponseBody
    @RequestMapping("deleteProblem")
    public void deleteProblem(Problem problem){
        problemService.deleteProblem(problem);
    }
}
