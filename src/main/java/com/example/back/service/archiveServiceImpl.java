package com.example.back.service;

import com.example.back.entity.Archive;
import com.example.back.mapper.ArchiveMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class archiveServiceImpl implements archiveService{
    @Resource
    ArchiveMapper archiveMapper;
    @Override
    public List<String> selectOrganization(Integer userId, String keyword){
        return archiveMapper.selectOrganization(userId, keyword);
    }
    @Override
    public List<String> selectService(Integer userId, String orgName, String keyword){
        return archiveMapper.selectService(userId, orgName, keyword);
    }
    @Override
    public List<Archive> selectArchive(Integer userId, String orgName, String svcName){
        return archiveMapper.selectArchive(userId, orgName, svcName);
    }

    @Override
    public Archive selectArchiveByID(Integer ID){
        return archiveMapper.selectArchiveByID(ID);
    }

    @Override
    public void deleteArchiveByID(Integer id){
        archiveMapper.deleteArchiveByID(id);
    }
}
