package com.example.app.miniprojectshopapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.app.miniprojectshopapi.vo.UserVO;

@Mapper
public interface UserMapper {
    int upsertUser(UserVO user);
    UserVO findByEmail(String email);
}