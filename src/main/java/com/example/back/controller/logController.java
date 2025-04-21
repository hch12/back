package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Admin;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class logController {
    @Resource
    com.example.back.service.logService logService;


    @GetMapping("/hello") // 接口的路径，全局唯一的
    public Result hello() {
        return Result.success("hello");  // 接口的返回值
    }

    @GetMapping("/selectAll")  //   完整的请求路径：http://ip:port/admin/selectAll
    public Result selectAll() {
        List<Admin> adminList = logService.selectAll();
        return Result.success(adminList);
    }
    @GetMapping("/admin") // 接口的路径，全局唯一的
    public Result admin(String name) {
        String admin=logService.admin(name);
        return Result.success(admin);  // 接口的返回值
    }
    @GetMapping("/selectPage") // 接口的路径，全局唯一的
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10")Integer pageSize) {
       PageInfo<Admin> page=logService.SelectPage(pageNum,pageSize);
       return Result.success();
    }
    @PostMapping("/login")
    public Result Login(@RequestBody Admin admin){
        {
            Admin dbadmin=logService.login(admin);
            return Result.success(dbadmin);
        }
    }
    @PostMapping("/register")
    public Result register(@RequestBody Admin admin){
        {
            Admin dbadmin=logService.register(admin);
            return Result.success(dbadmin);
        }
    }
}
