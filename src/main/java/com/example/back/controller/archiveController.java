package com.example.back.controller;

import com.example.back.common.Result;
import com.example.back.entity.Archive;
import com.example.back.entity.ArchiveDetail;
import com.example.back.entity.Indicator;
import com.example.back.service.archiveService;
import com.example.back.service.indicatorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/archive")
public class archiveController {
    @Resource
    archiveService archiveService;
    @Resource
    indicatorService indicatorService;

    @GetMapping("/{id}")
    public Result getArchiveById(@PathVariable Integer id){
        Archive archive = archiveService.selectArchiveByID(id);
        List<Indicator> indicators = indicatorService.selectIndicatorByArchive(id);
        List<String> uniqueNames = indicators.stream()
                .map(Indicator::getType)       // 提取属性（方法引用）
                .distinct()                  // 去重（基于 equals 方法）
                .collect(Collectors.toList());
        ArchiveDetail archiveDetail = new ArchiveDetail(archive, indicators, uniqueNames);
        return Result.success(archiveDetail);
    }

    @DeleteMapping("/{id}")
    public Result deleteArchiveById(@PathVariable Integer id){
        archiveService.deleteArchiveByID(id);
        indicatorService.deleteValueByArchiveID(id);
        return Result.success();
    }

    @PutMapping("/{id}")
    public Result alterValueById(@RequestBody List<Indicator> indicators,@PathVariable Integer id){
        for(Indicator indicator : indicators){
            Integer indicatorId = indicator.getId();
            String value = indicator.getValue();
            indicatorService.alterValueByArchiveID(indicatorId,id,value);
        }
        return Result.success();
    }
}
