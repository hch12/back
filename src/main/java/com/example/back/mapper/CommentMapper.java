package com.example.back.mapper;

import com.example.back.entity.Comment;
import com.example.back.entity.Organization;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT \"organizationID\",\"organizationName\" FROM organization " +
            "where  \"organizationName\" like concat('%',#{keyword},'%') " +
            "group by \"organizationID\", \"organizationName\" "+
            "ORDER BY \"organizationName\" ASC")
    List<Organization> selectOrganization(@Param("keyword") String keyword);

    @Select("SELECT c.*, o.\"organizationName\",a.\"username\" " +
            "FROM comments c " +
            "JOIN organization o ON c.organizationid = o.\"organizationID\" " +
            "JOIN admin a ON c.userid = a.\"id\" " +
            "WHERE (#{orgId,jdbcType=INTEGER} IS NULL OR c.organizationid = #{orgId,jdbcType=INTEGER}) " +
            "AND (#{userId,jdbcType=INTEGER} IS NULL OR c.userid = #{userId,jdbcType=INTEGER}) " +
            "ORDER BY c.createdat DESC ")
    List<Comment> selectComments(@Param("orgId") Integer orgId, @Param("userId") Integer userId);


    @Select("SELECT COUNT(*) FROM comments " +
            "WHERE (#{orgId,jdbcType=INTEGER} IS NULL OR organizationid = #{orgId,jdbcType=INTEGER}) " +
            "AND (#{userId,jdbcType=INTEGER} IS NULL OR userid = #{userId,jdbcType=INTEGER})")
    int countComments(@Param("orgId") Integer orgId, @Param("userId") Integer userId);

    @Insert("INSERT INTO comments(organizationid, userid, rating, commenttext) " +
            "VALUES(#{organizationid}, #{userid}, #{rating}, #{commenttext})")
    @Options(useGeneratedKeys = true, keyProperty = "commentid")
    int insertComment(Comment comment);

    @Update("UPDATE comments SET " +
            "rating = #{rating}, " +
            "commenttext = #{commenttext}, " +
            "updatedat = NOW() " +
            "WHERE commentid = #{commentid}")
    int updateComment(Comment comment);

    @Delete("DELETE FROM comments WHERE commentid = #{commentid}")
    int deleteComment(@Param("commentid") Integer commentid);
}