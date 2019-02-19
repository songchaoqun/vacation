package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.ProblemMapper;
import com.lyq.model.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProblemServiceImpl implements ProblemService{

    @Autowired
    private ProblemMapper problemMapper;

    //查询所有问题
    public Map<String, Object> queryProblem(Integer page, Integer rows) {
        Page<Problem> pageHelper = PageHelper.startPage(page, rows);
        List<Problem> queryMoleList = problemMapper.queryProblem();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //新增问题
    public void addProblem(Problem problem) {
        problemMapper.addProblem(problem);
    }

    //删除问题
    public void deleteProblem(Problem problem) {
        problemMapper.deleteProblem(problem);
    }
}
