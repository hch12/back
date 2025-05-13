package com.example.back.service;

import com.example.back.entity.Indicator;

import java.util.List;

public interface indicatorService {
    List<Indicator> selectIndicatorByArchive(Integer id);
    List<Indicator> selectValueByArchive(Integer id);
    void deleteValueByArchiveID(Integer id);
    void alterValueByArchiveID(Integer indicatorId,Integer id,String value);
    List<Indicator> selectIndicatorByService(Integer id);
    void insertValueByArchiveID(Integer id,Integer indicatorId,String value);
}
