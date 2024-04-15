package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.LoginRequest;
import com.example.bishe.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 登录鉴权模块
 */
@Tag(name = "登录鉴权模块", description = "登录注销")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public SaResult login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String token = userService.login(username, password);
        if (token == null) {
            return SaResult.error("登录失败");
        }

        return SaResult.ok().setData(token);
    }

    @GetMapping("isLogin")
    public SaResult isLogin() {
        Boolean login = userService.isLogin();
        if (login) {
            return SaResult.ok("已登录");
        }else {
            return SaResult.ok("未登录");
        }
    }

    @GetMapping("logout")
    public SaResult logout() {
        userService.logout();
        return SaResult.ok();
    }
}
