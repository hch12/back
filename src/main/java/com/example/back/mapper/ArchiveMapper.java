package com.example.back.mapper;

import com.example.back.entity.Archive;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public interface ArchiveMapper {
    @Select("SELECT \"organizationName\" FROM archive,service " +
            "where archive.\"serviceID\" = service.\"serviceID\" and \"userID\" = #{userId} " +
            "and \"organizationName\" like concat('%',#{keyword},'%') " +
            "group by \"organizationName\"")
    List<String> selectOrganization(@Param("userId") Integer userId,
                                    @Param("keyword") String keyword);

    @Select("SELECT \"serviceName\" FROM archive,service " +
            "where archive.\"serviceID\" = service.\"serviceID\" " +
            "and \"userID\" = #{userId} and \"organizationName\" = #{orgName} " +
            "and \"serviceName\" like concat('%',#{keyword},'%') " +
            "group by \"serviceName\"")
    List<String> selectService(@Param("userId") Integer userId,
                               @Param("orgName") String orgName,
                               @Param("keyword") String keyword);

    @Select("SELECT * FROM archive,service " +
            "where archive.\"serviceID\" = service.\"serviceID\" " +
            "and \"userID\" = #{userId} and \"organizationName\" like concat('%',#{orgName},'%') " +
            "and \"serviceName\" like concat('%',#{svcName},'%') " +
            "order by date desc")
    List<Archive> selectArchive(@Param("userId") Integer userId,
                                @Param("orgName") String orgName,
                                @Param("svcName") String svcName);

    @Select("SELECT \"archiveID\",name,\"organizationName\",\"serviceName\",date FROM archive,service,admin\n" +
            "where archive.\"serviceID\" = service.\"serviceID\" and archive.\"userID\" = id\n" +
            "and \"archiveID\" = #{id}")
    Archive selectArchiveByID(Integer id);

    @Delete("DELETE FROM archive where \"archiveID\" = #{id}")
    void deleteArchiveByID(Integer id);

    @Insert("INSERT INTO archive (\"archiveID\", \"userID\", \"serviceID\", date) " +
            "VALUES (DEFAULT, #{personId}, #{serviceId}, #{checkDate})")
    void insertArchive(@Param("personId") Integer personId,
                       @Param("serviceId") Integer serviceId,
                       @Param("checkDate") Date checkDate);

    @Select("select \"archiveID\" from archive\n " +
            "where \"userID\" = #{personId} and \"serviceID\" = #{serviceId} and date = #{checkDate}\n " +
            "order by date DESC")
    LinkedList<Integer> selectLatestArchiveId(@Param("personId") Integer personId,
                                              @Param("serviceId") Integer serviceId,
                                              @Param("checkDate") Date checkDate);
}