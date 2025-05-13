package com.example.back.entity;

import java.util.List;


/**
 * 套餐详细信息实体类 (DTO)
 * 聚合 Service, Organization, Indicator 表的数据
 */
public class ServiceDetail {
    // 来自 service 表
    private Integer serviceID;
    private String serviceName;
    // 使用 Organization 实体类，至少包含 organizationID, organizationName, city, phone, workdays
    private Organization organization;

    // 使用 List<Indicator>
    // Indicator 实体类至少包含 indicatorID, indicatorName, type, dataType
    private List<Indicator> indicators;


    private Double price; // 套餐价格
    private String description; // 套餐详细描述
    private String duration; // 预估时长

    // --- Getters and Setters ---

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ServiceDetail{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", organization=" + organization +
                ", indicators=" + indicators +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
