package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Admin;
import com.example.back.entity.Archive;
import com.example.back.entity.Record;
import com.example.back.service.archiveService;
import com.example.back.service.userService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/relative")
public class relativeController {
    @Resource
    userService userService;
    @Resource
    archiveService archiveService;

    @GetMapping("/name-suggest")
    public Result nameSuggest(@RequestParam String keyword, @RequestParam Integer id){
        List<Admin> adminList = userService.selectRelative(id, keyword);
        Record records = new Record(adminList, adminList.size());
        return Result.success(records);
    }

    @GetMapping("/org-suggest")
    public Result orgSuggest(@RequestParam String keyword, @RequestParam Integer nameId){
        List<String> orgList = archiveService.selectOrganization(nameId, keyword);
        Record records = new Record(orgList, orgList.size());
        return Result.success(records);
    }

    @GetMapping("/service-suggest")
    public Result svcSuggest(@RequestParam String keyword, @RequestParam Integer nameId, @RequestParam String orgName){
        List<String> svcList = archiveService.selectService(nameId, orgName, keyword);
        Record records = new Record(svcList, svcList.size());
        return Result.success(records);
    }

    @GetMapping("/list")
    public Result list(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam Integer nameId, @RequestParam String orgName, @RequestParam String serviceName){
        List<Archive> archives = archiveService.selectArchive(nameId, orgName, serviceName);
        int begin = (pageNum-1)*pageSize;
        int end = begin + pageSize;
        if(end > archives.size())
            end = archives.size();
        List<Archive> showList = new ArrayList<>(archives.subList(begin, end));
        Record records = new Record(showList, archives.size());
        return Result.success(records);
    }
}