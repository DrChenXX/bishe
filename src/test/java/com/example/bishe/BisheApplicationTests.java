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

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("bbb");
        user.setPassword("123456");
        user.setPhone("1357878898");
        boolean sava = userService.addUser(user);
        if (sava) {
            System.out.println("添加成功！");
        }
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setId(1L);
        user.setUsername("aaaa");
        boolean b = userService.updateUser(user);
        if (b) {
            System.out.println("修改成功！");
        }

    }

    @Test
    public void deleteUserById() {

    }


}
