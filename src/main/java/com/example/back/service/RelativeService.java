package com.example.back.service;

import com.example.back.entity.Relative;
import java.util.List;

public interface RelativeService {
    List<Relative> getRelativesByUser(Integer userId);
    void addRelative(int user_id,int re_id,String relationship);
    void updateRelative(Relative relative);
    void deleteRelative(Relative relative);
    void create(Relative relative);
    List<Relative> search(String username);
//    void toggleAuthorization(Integer regulator, Integer regulated, Boolean status);
}