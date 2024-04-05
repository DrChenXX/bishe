package com.example.bishe;

import com.example.bishe.mapper.UserMapper;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BisheApplicationTests {
    @Autowired
    private UserService userService;




}
