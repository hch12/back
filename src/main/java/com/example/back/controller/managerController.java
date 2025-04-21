package com.example.back.controller;
import com.example.back.service.managerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
@RestController("/manager")
public class managerController {
    @Resource
    managerService managerService;
}
