package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Organization;
import com.example.back.entity.Record;
import com.example.back.service.organizationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organization")
public class organizationController {
    @Resource
    organizationService organizationService;

    @GetMapping("/list")
    public Result list(@RequestParam int pageNum, @RequestParam int pageSize ){
        List<Organization> organizations = organizationService.selectAllOrganization();
        int begin = (pageNum-1)*pageSize;
        int end = begin + pageSize;
        if(end > organizations.size())
            end = organizations.size();
        List<Organization> showList = new ArrayList<> (organizations.subList(begin, end));
        Record records = new Record(showList, organizations.size());
        return Result.success(records);
    }

    @GetMapping("/suggest")
    public Result suggest(@RequestParam String keyword){
        List<Organization> organizations = organizationService.selectSearchedOrganization(keyword);
        Record records = new Record(organizations, organizations.size());
        return Result.success(records);
    }

    @GetMapping("/search")
    public Result search(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String name){
        List<Organization> organizations = organizationService.selectSearchedOrganization(name);
        int begin = (pageNum-1)*pageSize;
        int end = begin + pageSize;
        if(end > organizations.size())
            end = organizations.size();
        List<Organization> showList = new ArrayList<> (organizations.subList(begin, end));
        Record records = new Record(showList, organizations.size());
        return Result.success(records);
    }

    @GetMapping("/{id}")
    public Result getOrganizationById(@PathVariable Integer id){
        Organization organization = organizationService.selectOrganizationById(id);
        return Result.success(organization);
    }
}