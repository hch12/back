package com.example.back.entity;

public class Relative {
    private Integer regulator;
    private Integer regulated;
    private String username;
    private String relationship;
    private String phone;
    private String password;
    private String email;
//    private Boolean authorized;

    // Getters and Setters
    public Integer getRegulator() { return regulator; }
    public void setRegulator(Integer regulator) { this.regulator = regulator; }

    public Integer getRegulated() { return regulated; }
    public void setRegulated(Integer regulated) { this.regulated = regulated; }

    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

//    public Boolean getAuthorized() { return authorized; }
//    public void setAuthorized(Boolean authorized) { this.authorized = authorized; }
}