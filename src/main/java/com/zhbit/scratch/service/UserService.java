package com.zhbit.scratch.service;

import com.zhbit.scratch.domain.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    //根据邮箱获取用户信息
    User getUserByLoginMail(String loginMail);
    //根据手机获取用户信息
    User getUserByLoginMobile(String loginMobile);
    //计算该邮箱登录的用户个数
    int countByLoginMail(String loginMail);
    //计算该手机号码登录的用户个数
    int countByLoginMobile(String loginMobile);
    //添加用户
    void addUser(User user);
    //修改密码
    void modifyPassword(String userId, String password);

}
