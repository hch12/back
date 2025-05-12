package com.example.back.entity;

import java.util.List;

public class analysisRequest {
    Integer userId;
    List<Integer> indicatorIds;
    public List<Integer> getIndicatorIds() {
        return indicatorIds;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setIndicatorIds(List<Integer> indicatorIds) {
        this.indicatorIds = indicatorIds;
    }
}
