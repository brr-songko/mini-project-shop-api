package com.example.app.miniprojectshopapi.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import com.example.app.miniprojectshopapi.service.UserService;
import com.example.app.miniprojectshopapi.vo.UserVO;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody UserVO userVO, HttpSession session) {
        // Node가 보낸 구조와 비슷하게 { "param": [ {...} ] }
        UserVO user = new UserVO();
        user.setEmail(userVO.getEmail());
        user.setNickname(userVO.getNickname());
        user.setType(userVO.getType() == null ? 1 : (userVO.getType()));
        userService.upsertUser(user);
        // 세션 저장
        session.setAttribute("email", user.getEmail());
        session.setAttribute("nickname", user.getNickname());
        return user;
    }

    @PostMapping("/logout")
    public Object logout(HttpSession session) {
        session.invalidate();
        return java.util.Collections.singletonMap("result", "ok");
    }
}