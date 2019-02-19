package com.lyq.controller;

import com.lyq.model.Comment;
import com.lyq.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

//目录控制层
@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //新增评论
    @ResponseBody
    @RequestMapping("addComment")
    public void addComment(Comment comment){
        commentService.addComment(comment);
    }

    //修改回显评论
    @ResponseBody
    @RequestMapping("queryCommentById")
    public Comment queryCommentById(Comment comment){
        return commentService.queryCommentById(comment);
    }

    //修改评论
    @ResponseBody
    @RequestMapping("updateComment")
    public void updateComment(Comment comment){
        commentService.updateComment(comment);
    }

    //查询评论
    @ResponseBody
    @RequestMapping("queryComment")
    public Map<String , Object> queryComment(Integer page, Integer rows){
        return commentService.queryComment(page,rows);
    }

    //删除评论
    @ResponseBody
    @RequestMapping("deleteComment")
    public void deleteComment(Comment comment){
        commentService.deleteComment(comment);
    }
}
