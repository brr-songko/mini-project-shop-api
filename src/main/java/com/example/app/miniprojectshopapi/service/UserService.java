package com.example.app.miniprojectshopapi.service;

import org.springframework.stereotype.Service;
import com.example.app.miniprojectshopapi.mapper.UserMapper;
import com.example.app.miniprojectshopapi.vo.UserVO;

@Service
public class UserService {
    private final UserMapper userMapper;
    public UserService(UserMapper userMapper){ this.userMapper = userMapper; }

    public int upsertUser(UserVO user){ return userMapper.upsertUser(user); }
    public UserVO find(String email){ return userMapper.findByEmail(email); }
}
