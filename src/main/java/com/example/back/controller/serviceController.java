package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Record;
import com.example.back.entity.Service;
import com.example.back.service.serviceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
public class serviceController {
    @Resource
    serviceService serviceService;
    @GetMapping("/list")
    public Result list(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam String orgName){
        List<Service> services = serviceService.selectSearchedService(orgName);
        int begin = (pageNum-1)*pageSize;
        int end = begin + pageSize;
        if(end > services.size())
            end = services.size();
        List<Service> showList = new ArrayList<>(services.subList(begin, end));
        Record records = new Record(showList, services.size());
        return Result.success(records);
    }

    @GetMapping("/suggest")
    public Result suggest(@RequestParam String keyword, @RequestParam String orgName){
        List<Service> services = serviceService.selectServiceBySearch(keyword, orgName);
        Record records = new Record(services,services.size());
        return Result.success(records);
    }
}
