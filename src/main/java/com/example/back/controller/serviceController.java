package com.example.back.controller;

import com.example.back.entity.ServiceDetail;
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
    @GetMapping("/detail")
    public Result getServiceDetailById(@RequestParam("id") Integer id) {
        ServiceDetail serviceDetail = serviceService.getServiceDetailById(id);

        if (serviceDetail == null) {
            // 如果查询结果为 null，表示该 ID 的套餐不存在
            return Result.error("未找到该套餐信息"); // 返回错误码和信息
        }
        // 返回查询到的 ServiceDetail 对象
        return Result.success(serviceDetail);
    }
}
