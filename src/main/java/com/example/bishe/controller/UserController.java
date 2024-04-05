package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUserForm;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/allUser")
    public SaResult getAllUser() {
        List<User> allUser = userService.getAllUser();
        return SaResult.data(allUser);
    }

    @PostMapping("/addUser")
    public SaResult addUser(@RequestBody AddUserForm addUserForm) {
        Boolean added = userService.addUser(addUserForm);
        if (added) {
            return SaResult.ok().setMsg("用户添加成功");
        }
        return SaResult.error("添加用户失败");
    }

    @PostMapping()
    public SaResult updateUser(@RequestBody User user) {
        Boolean updated = userService.updateUser(user);
        if (updated) {
            return SaResult.ok().setMsg("用户更新成功");
        }
        return SaResult.error("添加更新失败");
    }

    @PostMapping()
    public SaResult getUserById(@RequestBody Long id) {
        User user = userService.getUserById(id);
        return SaResult.data(user);
    }

    @PostMapping("/delete")
    public SaResult deleteUser(@RequestBody Long id) {
        Boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return SaResult.ok().setMsg("删除用户成功");
        }
        return SaResult.error("删除用户失败");

    }

}
