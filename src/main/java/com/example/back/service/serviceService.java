package com.example.back.service;

import com.example.back.entity.Service;

import java.util.List;

public interface serviceService {
    List<Service> selectSearchedService(String name);
}
