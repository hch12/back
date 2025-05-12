package com.example.back.mapper;

import com.example.back.entity.ServiceDetail;
import com.example.back.entity.Service; // 导入 Service 实体，如果 selectServiceBySearch 方法需要的话
import org.apache.ibatis.annotations.*; // 保留需要的注解，但 @Results, @Select, @Collection 将在 XML 中实现

import java.util.List;

@Mapper // 仍然保留 @Mapper 注解让 Spring Boot 扫描到
public interface ServiceMapper {

    @Select("SELECT * FROM service WHERE \"organizationName\" like concat('%',#{name},'%')")
    List<Service> selectServiceBySearch(String name);

    /**
     * 根据套餐ID查询套餐详细信息
     * 使用 XML Mapping 实现复杂关联查询
     * @param id 套餐ID
     * @return 套餐详细信息，如果不存在则返回 null
     */
    ServiceDetail selectServiceDetailById(@Param("id") Integer id); // 只保留方法签名
}
