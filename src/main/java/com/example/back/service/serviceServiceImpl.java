package com.example.back.service;

import com.example.back.mapper.ServiceMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceServiceImpl implements serviceService{
    @Resource
    ServiceMapper serviceMapper;

    @Override
    public List<com.example.back.entity.Service> selectSearchedService(String name){
        return serviceMapper.selectServiceBySearch(name);
    }
}
