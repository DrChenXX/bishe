package com.example.bishe.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.bishe.model.dto.AddUserForm;
import com.example.bishe.model.dto.UpdatePasswordRequest;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理模块", description = "用户信息增删改查")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/allUser")
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

    @GetMapping("/getUserById")
    public SaResult getUserById(@RequestBody Long id) {
        User user = userService.getUserById(id);
        return SaResult.data(user);
    }

    @DeleteMapping("/delete")
    public SaResult deleteUser(@RequestBody Long id) {
        Boolean deleted = userService.deleteUser(id);
        if (Boolean.TRUE.equals(deleted)) {
            return SaResult.ok().setMsg("删除用户成功");
        }else {
            return SaResult.error("删除用户失败");
        }

    }

    @PostMapping("/resetPassword")
    public SaResult resetPassword(@RequestBody Long id) {
        Boolean b = userService.resetPassword(id);
        if (Boolean.TRUE.equals(b)) {
            return SaResult.ok().setMsg("密码重置成功");
        }else {
            return SaResult.error("密码重置失败");
        }
    }

    @PostMapping("/updatePassword")
    public SaResult updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        int updade = userService.updatePassword(updatePasswordRequest);
        if (updade > 0) {
            return SaResult.ok().setMsg("密码修改成功");
        } else if (updade == -1) {
            return SaResult.error("新密码和确认密码不相同");
        } else if (updade == -2) {
            return SaResult.error("原密码错误");
        } else {
            return SaResult.error("密码修改失败");
        }
    }

}
