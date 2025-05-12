package com.example.back.mapper;

import com.example.back.entity.Relative;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RelativeMapper {
    @Select("SELECT r.regulated, a.username, r.relationship, a.phone FROM relative r " +
            "JOIN admin a ON r.regulated = a.id " +
            "WHERE r.regulator = #{userId}" +
            "ORDER BY r.regulated ASC")
    List<Relative> selectByRegulator(Integer userId);

    @Insert("INSERT INTO relative (regulator, regulated, relationship) " +
            "VALUES (#{regulator}, #{id}, #{relationship})")
    int insert(@Param("regulator") int regulator, @Param("id") int id, @Param("relationship") String relationship);

    @Update("UPDATE relative SET relationship = #{relationship} " +
            "WHERE regulator = #{regulator} AND regulated = #{regulated}")
    int rela_update(Relative relative);

    @Update("UPDATE admin SET phone = #{phone} " +
            "WHERE id = #{regulated}")
    int phone_update(Relative relative);

    @Delete("DELETE FROM relative WHERE regulator = #{regulator} AND regulated = #{regulated}")
    int delete(Relative relative);

    @Select("SELECT username, id as regulated FROM admin " +
            "where username like concat('%',#{username},'%') " +
            "ORDER BY id ASC")
    List<Relative> selectByUsername(String username);

//    @Update("UPDATE relative SET authorized = #{status} " +
//            "WHERE regulator = #{regulator} AND regulated = #{regulated}")
//    int updateAuthorization(@Param("regulator") Integer regulator,
//                            @Param("regulated") Integer regulated,
//                            @Param("status") Boolean status);
}