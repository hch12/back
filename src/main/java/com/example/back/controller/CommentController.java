// Controller src/main/java/com/example/back/controller/CommentController.java
package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Archive;
import com.example.back.entity.Comment;
import com.example.back.entity.Organization;
import com.example.back.entity.Record;
import com.example.back.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/org-suggest")
    public Result orgSuggest(@RequestParam String keyword){
        List<Organization> orgList = commentService.selectOrganization(keyword);
        Record records = new Record(orgList, orgList.size());
        return Result.success(records);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(required = false) Integer orgId,
                       @RequestParam(required = false) Integer userId,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Comment> comments = commentService.getComments(orgId, userId);
        int begin = (pageNum-1)*pageSize;
        int end = begin + pageSize;
        if(end > comments.size())
            end = comments.size();
        List<Comment> showList = new ArrayList<>(comments.subList(begin, end));
        Record records = new Record(showList, comments.size());
        return Result.success(records);
    }

    @PostMapping("/create")
    public Result create(@RequestBody Comment comment) {
        int result = commentService.createComment(comment);
        return result > 0 ? Result.success() : Result.error("创建失败");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Comment comment) {
        int result = commentService.updateComment(comment);
        return result > 0 ? Result.success() : Result.error("更新失败");
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        int result = commentService.deleteComment(id);
        return result > 0 ? Result.success() : Result.error("删除失败");
    }
}