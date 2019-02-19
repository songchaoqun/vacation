package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.AnswerMapper;
import com.lyq.model.Answer;
import com.lyq.model.Mold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerMapper answerMapper;

    //查询该问题对应的所有答案
    public Map<String, Object> queryAnswer(Integer page, Integer rows, Integer id) {
        Page<Answer> pageHelper = PageHelper.startPage(page, rows);
        List<Answer> queryMoleList = answerMapper.queryAnswer(id);
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //新增答案
    public void addAnswer(Answer answer) {
        answerMapper.addAnswer(answer);
    }

    //删除答案
    public void deleteAnswer(Answer answer) {
        answerMapper.deleteAnswer(answer);
    }
}