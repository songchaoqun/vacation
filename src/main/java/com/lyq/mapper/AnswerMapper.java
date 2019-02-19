package com.lyq.mapper;

import com.lyq.model.Answer;

import java.util.List;

public interface AnswerMapper {
    //查询该问题对应的所有答案
    List<Answer> queryAnswer(Integer id);
    //新增答案
    void addAnswer(Answer answer);
    //删除答案
    void deleteAnswer(Answer answer);
}
