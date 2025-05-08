package com.example.back.entity;

public class Organization {
    private Integer organizationID;
    private String organizationName;
    private String city;
    private String phone;
    private String workdays;

    public Integer getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Integer organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganization_name(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkdays() {
        return workdays;
    }

    public void setWorkdays(String workdays) {
        this.workdays = workdays;
    }

}
