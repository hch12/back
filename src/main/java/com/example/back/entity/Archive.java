package com.example.back.entity;

import java.util.Date;

public class Archive {
    private Integer archiveID;
    private String name;
    private String organizationName;
    private String serviceName;
    private Date date;
    public Integer getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Integer archiveID) {
        this.archiveID = archiveID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
