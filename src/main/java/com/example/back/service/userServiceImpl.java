package com.example.back.service;

import com.example.back.entity.Admin;
import com.example.back.entity.Indicator;
import com.example.back.entity.IndicatorData;
import com.example.back.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userServiceImpl implements userService{
    @Resource
    UserMapper userMapper;

    @Override
    public void SetAdminById(Integer id, String name, String email, String phone) {
         userMapper.SetAdminById(id,name,email,phone);
    }

    @Override
    public void SetAdminPasswordById(Integer id, String password) {
        userMapper.SetAdminPassageById(id,password);
    }

    @Override
    public List<Admin> selectRelative(Integer userId, String keyword){
        return userMapper.selectRelative(userId, keyword);
    }

    @Override
    public List<IndicatorData> getByIndicatorIds(Integer ID,List<Integer> idList) {
        List<IndicatorData> result =new ArrayList<>();

        for (Integer i:idList)
        {
            List<IndicatorData> temp=userMapper.selectindicatorsTrend(ID,i);
            result.addAll(temp);
        }
        return result;
    }
}
