package com.example.back.mapper;


import com.example.back.entity.Service;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ServiceMapper {
    @Select("SELECT * FROM service WHERE \"organizationName\" like concat('%',#{name},'%')")
    List<Service> selectServiceBySearch(String name);
}
