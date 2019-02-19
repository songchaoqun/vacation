package com.lyq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyq.mapper.CommentMapper;
import com.lyq.model.Comment;
import com.lyq.model.Mold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    //新增评论
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    //修改回显评论
    public Comment queryCommentById(Comment comment) {
        return commentMapper.queryCommentById(comment);
    }

    //修改评论
    public void updateComment(Comment comment) {
        commentMapper.updateComment(comment);
    }

    //查询评论
    public Map<String, Object> queryComment(Integer page, Integer rows) {
        Page<Comment> pageHelper = PageHelper.startPage(page, rows);
        List<Comment> queryMoleList = commentMapper.queryComment();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("total", pageHelper.getTotal());
        dataMap.put("rows", queryMoleList);
        return dataMap;
    }

    //删除评论
    public void deleteComment(Comment comment) {
        commentMapper.deleteComment(comment);
    }
}
