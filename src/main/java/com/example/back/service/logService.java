package com.example.back.service;

import com.example.back.entity.Admin;
import com.example.back.entity.Relative;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface logService {
    List<Admin> selectAll();

    String admin(String name);
    PageInfo SelectPage(Integer pageNum, Integer pageSize);
    Admin login(Admin admin);
    Admin register(Admin admin);
    Admin SelectAdminById(Integer id);
}
