package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Admin;
import com.example.back.service.logService;
import com.example.back.service.userService;
import com.example.back.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Resource
    userService userService;

    @Resource
    logService logService;

    @PostMapping("/personalinfo")
    public Result fetchPersonalInfo(@RequestBody Integer id){

        Admin dbadmin = logService.SelectAdminById(id);
        return Result.success(dbadmin);
    }
    @PostMapping("/updatePersonalInfo")
    public Result updatePersonalInfo(@RequestBody Admin admin){
        Integer id =admin.getId();
        String name= admin.getName();
        String phone =admin.getPhone();
        String email=admin.getEmail();
        userService.SetAdminById(id,name,email,phone);
        Admin dbadmin=logService.SelectAdminById(id);
        String token= TokenUtils.createToken(dbadmin.getId()+"-"+dbadmin.getUsername(),dbadmin.getPassword());
        dbadmin.setPassword("***");
        dbadmin.setToken(token);
        return Result.success(dbadmin);
    }
    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody Admin admin){
        Integer id =admin.getId();
        String password=admin.getPassword();
        userService.SetAdminPasswordById(id,password);
        Admin dbadmin=logService.SelectAdminById(id);
        String token= TokenUtils.createToken(dbadmin.getId()+"-"+dbadmin.getUsername(),dbadmin.getPassword());
        dbadmin.setPassword("***");
        dbadmin.setToken(token);
        return Result.success(dbadmin);
    }

}