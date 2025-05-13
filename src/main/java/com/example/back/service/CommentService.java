// Service接口 src/main/java/com/example/back/service/CommentService.java
package com.example.back.service;

import com.example.back.entity.Comment;
import com.example.back.entity.Organization;
import com.example.back.entity.Record;

import java.util.List;

public interface CommentService {
    List<Organization> selectOrganization(String keyword);
    List<Comment> getComments(Integer orgId, Integer userId);
    int createComment(Comment comment);
    int updateComment(Comment comment);
    int deleteComment(Integer commentid);
}