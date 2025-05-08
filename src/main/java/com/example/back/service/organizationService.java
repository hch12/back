package com.example.back.service;

import com.example.back.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.List;
public interface organizationService {
    List<Organization> selectAllOrganization();

    List<Organization> selectSearchedOrganization(String name);

    Organization selectOrganizationById(Integer id);
}
