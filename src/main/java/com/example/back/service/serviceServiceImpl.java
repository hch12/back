package com.example.back.service;

import com.example.back.entity.ServiceDetail;
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

    @Override
    public List<com.example.back.entity.Service> selectServiceBySearch(String keyword, String orgName){
        return serviceMapper.selectServiceByOrg(keyword, orgName);
    }
    public ServiceDetail getServiceDetailById(Integer id) {
        return serviceMapper.selectServiceDetailById(id);
    }

}
