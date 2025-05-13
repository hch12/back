package com.example.back.service;

import com.example.back.entity.Service;
import org.apache.ibatis.annotations.Param;
import com.example.back.entity.ServiceDetail;

import java.util.List;

public interface serviceService {
    List<Service> selectSearchedService(String name);

    List<Service> selectServiceBySearch(String keyword, String orgName);
    ServiceDetail getServiceDetailById(Integer id);
}
