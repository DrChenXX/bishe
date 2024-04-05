package com.example.bishe.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe.model.dto.AddUserForm;
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
    implements UserService{

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    @Override
    public String login(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        queryWrapper.eq(User::getPassword, password);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return null;
        }else {
            StpUtil.login(user.getId());
        }
        return StpUtil.getTokenValue();
    }

    /**
     * 判断用户是否已登录
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
    public List<User> getAllUser() {
        //TODO 分页查询
        return this.list();
    }

    /**
     * 添加用户
     * @param addUserForm 用户添加表单
     * @return true/false
     */
    @Override
    public Boolean addUser(AddUserForm addUserForm) {
        User user = new User();
        user.setUsername(addUserForm.getUsername());
        user.setPassword(SaSecureUtil.md5(PASSWORD));
        user.setPhone(addUserForm.getPhone());
        if (addUserForm.getEmail() != null) {
            user.setEmail(addUserForm.getEmail());
        }
        user.setAvatarUrl(AVATAR_URL);
        int insert = userMapper.insert(user);
        //TODO 添加角色信息
        return insert >= 1;
    }

    @Override
    public Boolean deleteUser(Long id) {
        int delete = userMapper.deleteById(id);
        //TODO 从角色用户关联表中删除
        return delete >= 0;
    }

    /**
     * 更新用户
     * @param user 用户实体
     */
    @Override
    public Boolean updateUser(User user) {
        int update = userMapper.updateById(user);
        return update >= 0;
    }

    /**
     * 根据用户ID查询用户
     * @param id 用户ID
     */
    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
}




