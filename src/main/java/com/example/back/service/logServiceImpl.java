package com.example.back.service;

import com.example.back.entity.Admin;
import com.example.back.exception.CustomerException;
import com.example.back.mapper.AdminMapper;
import com.example.back.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class logServiceImpl implements logService {

    @Resource
    AdminMapper adminMapper;

    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    public String admin(String name) {
        if ("admin".equals(name)) {
            return "admin";
        }
        else {
            throw new CustomerException("账号错误");
        }
    }

    @Override
    public PageInfo<Admin> SelectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> adminList=adminMapper.selectAll();
        return PageInfo.of(adminList);
    }

    @Override
    public Admin login(Admin admin) {
        Admin dbadmin = adminMapper.selectByUsername(admin.getUsername());
        if(dbadmin== null)
        {
            throw new CustomerException("账号不存在");
        }
        if(!dbadmin.getPassword().equals(admin.getPassword()))
        {
            throw new CustomerException("账号或密码错误");
        }
        String token=TokenUtils.createToken(dbadmin.getId()+"-"+dbadmin.getUsername(),dbadmin.getPassword());
        dbadmin.setPassword("***");
        dbadmin.setToken(token);
        return dbadmin;
    }

    @Override
    public Admin register(Admin admin) {
        Admin dbadmin=adminMapper.selectByUsername(admin.getUsername());
        if(dbadmin!=null)
        {
            throw new CustomerException("用户名已存在");
        }
        else
        {
            adminMapper.insertAdmin(admin.getUsername(),admin.getPassword(),admin.getEmail());
            Admin newAccount=adminMapper.selectByUsername(admin.getUsername());
            return newAccount;
        }
    }

    @Override
    public Admin SelectAdminById(Integer id) {
        return adminMapper.selectAdminById(id);
    }
}
