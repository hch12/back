package com.example.back.entity;

import java.time.LocalDate;

public class IndicatorData {
    private Integer indicatorId;        // 指标ID
    private String indicatorName;       // 指标名称
    private LocalDate date;             // 日期（Java 8时间类型，自动序列化为YYYY-MM-DD）
    private String value;               // 指标值（字符串类型，兼容数值和文本）

    public Integer getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(Integer indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
