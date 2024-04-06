package com.example.bishe.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddUserForm;
import com.example.bishe.model.dto.UpdatePasswordRequest;
import com.example.bishe.model.entity.User;
import com.example.bishe.service.UserService;
import com.example.bishe.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bishe.contnat.UserConstant.AVATAR_URL;
import static com.example.bishe.contnat.UserConstant.PASSWORD;

/**
* @author talha
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-04-03 11:11:29
*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @Override
    public String login(String username, String password) {
        String s = SaSecureUtil.md5(password);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        queryWrapper.eq(User::getPassword, s);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return null;
        } else {
            StpUtil.login(user.getId());
        }
        return StpUtil.getTokenValue();
    }

    /**
     * 判断用户是否已登录
     *
     * @return true/false
     */
    @Override
    public Boolean isLogin() {
        return StpUtil.isLogin();
    }

    /**
     * 用户登出
     */
    @Override
    public void logout() {
        StpUtil.logout();
    }

    /**
     * 获取所有用户
     * @return 所有用户
     */
    @Override
    public List<User> getUserList() {
        //TODO 分页查询
        return this.list();
    }

    /**
     * 添加用户
     *
     * @param addUserForm 用户添加表单
     * @return true/false
     */
    @Override
    public int addUser(AddUserForm addUserForm) {
        User user = new User();
        user.setUsername(addUserForm.getUsername());
        user.setPassword(SaSecureUtil.md5(PASSWORD));
        user.setPhone(addUserForm.getPhone());
        if (addUserForm.getEmail() != null) {
            user.setEmail(addUserForm.getEmail());
        }
        user.setAvatarUrl(AVATAR_URL);
        return userMapper.insert(user);
        //TODO 添加角色信息
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteById(id);
        //TODO 从角色用户关联表中删除
    }

    /**
     * 更新用户
     *
     * @param user 用户实体
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    /**
     * 根据用户ID查询用户
     *
     * @param id 用户ID
     */
    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }

    /**
     * 重置密码
     * @param id 用户id
     */
    @Override
    public int resetPassword(Long id) {
        User user = userMapper.selectById(id);
        user.setPassword(SaSecureUtil.md5(PASSWORD));
        return userMapper.updateById(user);

    }

    /**
     * 修改密码
     * @param updatePasswordRequest 密码
     */
    @Override
    public int updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        Long loginId = Long.valueOf(String.valueOf(StpUtil.getLoginId())).longValue();
        User user = userMapper.selectById(loginId);
        //比较新密码和确认密码
        if (!updatePasswordRequest.getNewPassword().equals(updatePasswordRequest.getConfirmPassword())) {
            return -1;
        }
        //比较用户提交的旧密码和数据库中存储的密码
        if (!user.getPassword().equals(SaSecureUtil.md5(updatePasswordRequest.getOldPassword()))) {
            return -2;
        } else {
            //修改密码
            user.setPassword(SaSecureUtil.md5(updatePasswordRequest.getNewPassword()));
            return userMapper.updateById(user);
        }

    }
}




