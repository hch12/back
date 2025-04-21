package com.example.back.mapper;

import com.example.back.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void SetAdminById(@Param("id") Integer id,@Param("name") String name, @Param("email") String email, @Param("phone") String phone);

    void SetAdminPassageById(@Param("id") Integer id, @Param("password") String password);
}
