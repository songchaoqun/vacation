package com.lyq.service;

import com.lyq.model.Comment;

import java.util.Map;

public interface CommentService {
    //新增评论
    void addComment(Comment comment);
    //修改回显评论
    Comment queryCommentById(Comment comment);
    //修改评论
    void updateComment(Comment comment);
    //查询评论
    Map<String, Object> queryComment(Integer page, Integer rows);
    //删除评论
    void deleteComment(Comment comment);
}
