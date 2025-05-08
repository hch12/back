package com.example.back.service;

import com.example.back.entity.Organization;
import com.example.back.mapper.OrganizationMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class organizationServiceImpl implements organizationService{
    @Resource
    OrganizationMapper organizationMapper;
    @Override
    public List<Organization> selectAllOrganization(){
        return organizationMapper.selectAllOrganization();
    }

    @Override
    public List<Organization> selectSearchedOrganization(String name){
        return organizationMapper.selectOrganizationBySearch(name);
    }

    @Override
    public Organization selectOrganizationById(Integer id){
        return organizationMapper.selectOrganizationByID(id);
    }
}
