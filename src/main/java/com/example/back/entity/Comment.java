package com.example.back.entity;

import java.time.OffsetDateTime; // 或者 java.time.ZonedDateTime

public class Comment {
    private Integer commentid;
    private Integer organizationid;
    private Integer userid;
    private Integer rating;
    private String commenttext;
    private OffsetDateTime createdat; // 修改为 OffsetDateTime
    private OffsetDateTime updatedat; // 修改为 OffsetDateTime
    private String organizationName;
    private String username;

    // getters and setters
    public Integer getCommentid() { return commentid; }
    public void setCommentid(Integer commentid) { this.commentid = commentid; }
    public Integer getOrganizationid() { return organizationid; }
    public void setOrganizationid(Integer organizationid) { this.organizationid = organizationid; }
    public Integer getUserid() { return userid; }
    public void setUserid(Integer userid) { this.userid = userid; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    public String getCommenttext() { return commenttext; }
    public void setCommenttext(String commenttext) { this.commenttext = commenttext; }
    public OffsetDateTime getCreatedat() { return createdat; }
    public void setCreatedat(OffsetDateTime createdat) { this.createdat = createdat; }
    public OffsetDateTime getUpdatedat() { return updatedat; }
    public void setUpdatedat(OffsetDateTime updatedat) { this.updatedat = updatedat; }
    public String getOrganizationName() { return organizationName; }
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
