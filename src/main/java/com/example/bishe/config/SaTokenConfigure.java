package com.example.bishe.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    //放行路径
    private static final String[] EXCLUDE_PATH_PATTERNS = {
            "**/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**",
            "/v3/**",
            "/swagger-ui.html/**",
            "/swagger-ui/**",
            "/swagger-ui/index.html#/**",
            "/doc.html/**",
            "/error",
            "/favicon.ico",
    };
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/auth/login")
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS);
    }
}