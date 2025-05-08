package com.example.back.mapper;

import com.example.back.entity.Organization;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrganizationMapper {
    @Select("select * from organization")
    List<Organization> selectAllOrganization();

    @Select("SELECT * FROM organization WHERE \"organizationName\" like concat('%',#{name},'%')")
    List<Organization> selectOrganizationBySearch(String name);

    @Select("SELECT * FROM organization WHERE \"organizationID\" = #{id}")
    Organization selectOrganizationByID(Integer id);

}
