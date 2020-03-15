package com.zhbit.scratch.service.impl;

import com.zhbit.scratch.dao.UserDao;
import com.zhbit.scratch.domain.entity.User;
import com.zhbit.scratch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /**
     * 通过邮箱拿到用户信息
     */
    @Override
    public User getUserByLoginMail(String loginMail) {
        Map<String, String> userParam = new HashMap<>();
        userParam.put("email", loginMail);
        return this.userDao.selectUser(userParam);
    }

    /**
     * 通过手机号码拿到用户信息
     */
    @Override
    public User getUserByLoginMobile(String loginMobile) {
        Map<String, String> userParam = new HashMap<>();
        userParam.put("mobile", loginMobile);
        return this.userDao.selectUser(userParam);
    }

    /**
     * 通过邮箱查找用户数量
     */
    @Override
    public int countByLoginMail(String loginMail) {
        return this.userDao.countByLoginName(loginMail);
    }

    /**
     * 通过手机号查找用户数量
     */
    @Override
    public int countByLoginMobile(String loginMobile) {
        return this.userDao.countByLoginName(loginMobile);
    }

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    /**
     * 修改密码操作
     */
    @Override
    public void modifyPassword(String userId, String password) {
        this.userDao.updatePassword(userId, password);
    }
}
