package com.lyq.mapper;

import com.lyq.model.Comment;

import java.util.List;

public interface CommentMapper {
    //新增评论
    void addComment(Comment comment);
    //修改回显评论
    Comment queryCommentById(Comment comment);
    //修改评论
    void updateComment(Comment comment);
    //查询评论
    List<Comment> queryComment();
    //删除评论
    void deleteComment(Comment comment);
}
