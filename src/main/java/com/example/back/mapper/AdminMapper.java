package com.example.back.mapper; // 必须与目录路径匹配

import com.example.back.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {

    List<Admin> selectAll();

    @Select("select * from admin where username = #{username}")
    Admin selectByUsername(String username);
    int insertAdmin(
            @Param("username") String username,
            @Param("password") String password,
            @Param("email") String email
    );
    @Select("select * from admin where id = #{id}")
    Admin selectAdminById(Integer id);
}