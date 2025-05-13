package com.example.back.service;

import com.example.back.entity.Admin;
import com.example.back.entity.Relative;
import com.example.back.exception.CustomerException;
import com.example.back.mapper.AdminMapper;
import com.example.back.mapper.RelativeMapper;
import com.example.back.service.RelativeService;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class RelativeServiceImpl implements RelativeService {

    @Resource
    private RelativeMapper relativeMapper;
    @Resource
    AdminMapper adminMapper;

    @Override
    public List<Relative> getRelativesByUser(Integer userId) {
        return relativeMapper.selectByRegulator(userId);
    }

    @Override
    public void addRelative(int user_id,int re_id,String relationship) {
        relativeMapper.insert(user_id,re_id,relationship);
    }

    @Override
    public void updateRelative(Relative relative) {
        relativeMapper.rela_update(relative);
        relativeMapper.phone_update(relative);
    }

    @Override
    public void deleteRelative(Relative relative) {
        relativeMapper.delete(relative);
    }

    @Override
    public void create(Relative relative){
        Admin dbadmin=adminMapper.selectByUsername(relative.getUsername());
        if(dbadmin!=null)
        {
            throw new CustomerException("用户名已存在");
        }
        else
        {
            adminMapper.insertAdmin(relative.getUsername(),relative.getPassword(),relative.getEmail());
            Admin newAccount=adminMapper.selectByUsername(relative.getUsername());
            relativeMapper.insert(relative.getRegulator(), newAccount.getId(), relative.getRelationship());
            relative.setRegulated(newAccount.getId());
            if(relative.getPhone()!=null){
                relativeMapper.phone_update(relative);
            }
        }
    }

    @Override
    public List<Relative> search(String username){
        return relativeMapper.selectByUsername(username);
    }
//    @Override
//    public void toggleAuthorization(Integer regulator, Integer regulated, Boolean status) {
//        relativeMapper.updateAuthorization(regulator, regulated, status);
//    }
}