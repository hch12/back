package com.example.back.entity;

public class Indicator {
    private Integer id;
    private Integer indicatorID;
    private String indicatorName;
    private String type;
    private Integer dataType;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndicatorID() {
        return indicatorID;
    }

    public void setIndicatorID(Integer indicatorID) {
        this.indicatorID = indicatorID;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
