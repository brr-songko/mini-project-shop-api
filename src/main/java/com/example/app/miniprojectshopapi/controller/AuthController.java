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
    public AuthController(UserService userService){ this.userService = userService; }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String,Object> body, HttpSession session){
        // Node가 보낸 구조와 비슷하게 { "param": [ {...} ] }
        Object param = body.get("param");
        if (param instanceof java.util.List) {
            @SuppressWarnings("unchecked")
            Map<String,Object> u = ((java.util.List<Map<String,Object>>)param).get(0);
            UserVO user = new UserVO();
            user.setEmail((String)u.get("email"));
            user.setNickname((String)u.get("nickname"));
            user.setType(u.get("type") == null ? 1 : ((Number)u.get("type")).intValue());
            userService.upsertUser(user);
            // 세션 저장
            session.setAttribute("email", user.getEmail());
            session.setAttribute("nickname", user.getNickname());
            return user;
        }
        return java.util.Collections.singletonMap("error","invalid param");
    }

    @PostMapping("/logout")
    public Object logout(HttpSession session){
        session.invalidate();
        return java.util.Collections.singletonMap("result","ok");
    }
}