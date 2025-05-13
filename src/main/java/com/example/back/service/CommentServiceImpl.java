package com.example.back.service;

import com.example.back.entity.Comment;
import com.example.back.entity.Organization;
import com.example.back.entity.Record;
import com.example.back.mapper.CommentMapper;
import com.example.back.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Organization> selectOrganization(String keyword){
        return commentMapper.selectOrganization(keyword);
    }

    @Override
    public List<Comment> getComments(Integer orgId, Integer userId) {
        return commentMapper.selectComments(orgId, userId);
    }

    @Override
    public int createComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    @Override
    public int deleteComment(Integer commentid) {
        return commentMapper.deleteComment(commentid);
    }
}
