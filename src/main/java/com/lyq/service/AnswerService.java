package com.lyq.service;

import com.lyq.model.Answer;

import java.util.Map;

public interface AnswerService {
    //查询该问题对应的所有答案
    Map<String, Object> queryAnswer(Integer page, Integer rows, Integer id);
    //新增答案
    void addAnswer(Answer answer);
    //删除答案
    void deleteAnswer(Answer answer);
}
