package com.example.back.mapper;

import com.example.back.entity.Admin;
import com.example.back.entity.IndicatorData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    void SetAdminById(@Param("id") Integer id,@Param("name") String name, @Param("email") String email, @Param("phone") String phone);

    void SetAdminPassageById(@Param("id") Integer id, @Param("password") String password);

    @Select("SELECT name, id FROM relative,admin " +
            "where regulated = id " +
            "and regulator = #{userId} " +
            "and name like concat('%',#{keyword},'%')")
    List<Admin> selectRelative(@Param("userId") Integer userId,
                                    @Param("keyword") String keyword);
    @Select("SELECT indicator_archive.\"indicatorID\", indicator.\"indicatorName\", archive.date, indicator_archive.value " +
            "FROM archive, indicator, indicator_archive " +
            "WHERE archive.\"userID\" = #{ID} " +
            "AND archive.\"archiveID\" = indicator_archive.\"archiveID\" " +
            "AND indicator_archive.\"indicatorID\" = indicator.\"indicatorID\" " +
            "AND indicator_archive.\"indicatorID\" = #{IndicatorId} " +
            "ORDER BY date ASC")
    List<IndicatorData> selectindicatorsTrend(@Param("ID") Integer ID, @Param("IndicatorId") Integer IndicatorId);

}
