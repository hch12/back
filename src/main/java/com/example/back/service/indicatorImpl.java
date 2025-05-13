package com.example.back.service;

import com.example.back.entity.Indicator;
import com.example.back.mapper.IndicatorMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class indicatorImpl implements indicatorService{
    @Resource
    IndicatorMapper indicatorMapper;

    @Override
    public List<Indicator> selectIndicatorByArchive(Integer id){
        return indicatorMapper.selectIndicatorByArchive(id);
    }
    @Override
    public List<Indicator> selectValueByArchive(Integer id){
        return indicatorMapper.selectValueByArchive(id);
    }
    @Override
    public void deleteValueByArchiveID(Integer id){
        indicatorMapper.deleteValueByArchiveID(id);
    }
    @Override
    public void alterValueByArchiveID(Integer indicatorId,Integer id,String value){
        indicatorMapper.alterValueByArchiveID(indicatorId,id,value);
    }
    @Override
    public List<Indicator> selectIndicatorByService(Integer id){
        return indicatorMapper.selectIndicatorByService(id);
    }
    @Override
    public void insertValueByArchiveID(Integer id,Integer indicatorId,String value){
        indicatorMapper.insertValueByArchiveID(id,indicatorId,value);
    }
}
