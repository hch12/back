package com.example.back.service;

import com.example.back.entity.Admin;

public interface userService {
    void SetAdminById(Integer id, String name, String email, String phone);

    void SetAdminPasswordById(Integer id, String password);
}
