package com.example.back.mapper;

import com.example.back.entity.Admin;
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
}
