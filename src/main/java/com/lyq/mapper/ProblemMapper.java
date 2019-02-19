package com.lyq.mapper;

import com.lyq.model.Problem;

import java.util.List;

public interface ProblemMapper {
    //查询所有问题
    List<Problem> queryProblem();
    //新增问题
    void addProblem(Problem problem);
    //删除问题
    void deleteProblem(Problem problem);
}
