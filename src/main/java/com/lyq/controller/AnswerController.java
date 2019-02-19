package com.lyq.controller;

import com.lyq.model.Answer;
import com.lyq.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//答案控制层
@Controller
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    //查询该问题对应的所有答案
    @ResponseBody
    @RequestMapping("queryAnswer")
    public Map<String , Object> queryAnswer(Integer page, Integer rows,Integer id){
        return answerService.queryAnswer(page,rows,id);
    }

    //新增答案
    @ResponseBody
    @RequestMapping("addAnswer")
    public void addAnswer(Answer answer){
        answerService.addAnswer(answer);
    }

    //删除答案
    @ResponseBody
    @RequestMapping("deleteAnswer")
    public void deleteAnswer(Answer answer){
        answerService.deleteAnswer(answer);
    }
}
