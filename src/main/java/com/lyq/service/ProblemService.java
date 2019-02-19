package com.lyq.service;

import com.lyq.model.Problem;

import java.util.Map;

public interface ProblemService {
    //查询所有问题
    Map<String, Object> queryProblem(Integer page, Integer rows);
    //新增问题
    void addProblem(Problem problem);
    //删除问题
    void deleteProblem(Problem problem);
}
