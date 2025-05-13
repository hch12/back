package com.example.back.mapper;


import com.example.back.entity.Indicator;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IndicatorMapper {
    @Select("SELECT indicator.\"indicatorID\" as id,\"indicatorName\",type,\"dataType\",value FROM archive\n" +
            "join service_indicator on archive.\"serviceID\" = service_indicator.\"serviceID\"\n" +
            "join indicator on indicator.\"indicatorID\" = service_indicator.\"indicatorID\"\n" +
            "left join indicator_archive on indicator.\"indicatorID\" = indicator_archive.\"indicatorID\" and archive.\"archiveID\" = indicator_archive.\"archiveID\"\n" +
            "where archive.\"archiveID\" = #{id}")
    List<Indicator> selectIndicatorByArchive(Integer id);

    @Select("SELECT indicator.\"indicatorID\" as id,type,value FROM archive,indicator_archive,indicator\n" +
            "where archive.\"archiveID\" = indicator_archive.\"archiveID\" and indicator.\"indicatorID\" = indicator_archive.\"indicatorID\"\n" +
            "and archive.\"archiveID\" = #{id}")
    List<Indicator> selectValueByArchive(Integer id);

    @Delete("DELETE FROM indicator_archive where \"archiveID\" = #{id}")
    void deleteValueByArchiveID(Integer id);

    @Update("UPDATE indicator_archive SET value = #{value} WHERE \"archiveID\" = #{id} AND \"indicatorID\" = #{indicatorId}")
    void alterValueByArchiveID(@Param("indicatorId") Integer indicatorId,
                               @Param("id") Integer id,
                               @Param("value") String value);

    @Select("SELECT indicator.\"indicatorID\" as id,\"indicatorName\",type,\"dataType\" FROM service_indicator\n" +
            "join indicator on service_indicator.\"indicatorID\" = indicator.\"indicatorID\"\n" +
            "where \"serviceID\" = #{id}")
    List<Indicator> selectIndicatorByService(Integer id);

    @Insert("INSERT INTO indicator_archive (\"archiveID\", \"indicatorID\", value) " +
            "VALUES (#{id}, #{indicatorId}, #{value})")
    void insertValueByArchiveID(@Param("id") Integer id,
                               @Param("indicatorId") Integer indicatorId,
                               @Param("value") String value);
}
