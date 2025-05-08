package com.example.back.service;

import com.example.back.entity.Archive;
import com.example.back.entity.Organization;

import java.util.List;

public interface archiveService {
    List<String> selectOrganization(Integer userId, String keyword);
    List<String> selectService(Integer userId, String orgName, String keyword);
    List<Archive> selectArchive(Integer userId, String orgName, String svcName);

    Archive selectArchiveByID(Integer ID);
    void deleteArchiveByID(Integer id);
}
