package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.LoginRequest;
import com.example.bishe.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param loginRequest 登录实体
     * @return token
     */
    @RequestMapping("/login")
    public SaResult login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String token = userService.login(username, password);
        if (token == null) {
            return SaResult.error("登录失败");
        }

        return SaResult.ok().setData(token);
    }

    @RequestMapping("isLogin")
    public SaResult isLogin() {
        Boolean login = userService.isLogin();
        if (login) {
            return SaResult.ok("已登录");
        }else {
            return SaResult.ok("未登录");
        }
    }

    @RequestMapping("logout")
    public SaResult logout() {
        userService.logout();
        return SaResult.ok();
    }
}
