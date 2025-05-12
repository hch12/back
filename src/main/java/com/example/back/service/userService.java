package com.example.back.service;

import com.example.back.entity.Admin;
import com.example.back.entity.IndicatorData;

import java.util.List;

public interface userService {
    void SetAdminById(Integer id, String name, String email, String phone);

    void SetAdminPasswordById(Integer id, String password);
    List<Admin> selectRelative(Integer userId, String keyword);
    List<IndicatorData>getByIndicatorIds(Integer ID,List<Integer>idList);
}
