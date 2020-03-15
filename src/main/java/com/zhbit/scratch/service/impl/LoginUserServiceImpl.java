package com.zhbit.scratch.service.impl;

import com.zhbit.scratch.Utils.RegexUtils;
import com.zhbit.scratch.base.HttpStatus;
import com.zhbit.scratch.domain.entity.User;
import com.zhbit.scratch.domain.result.LoginResult;
import com.zhbit.scratch.exception.BusinessException;
import com.zhbit.scratch.service.LoginUserService;
import com.zhbit.scratch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登录实现
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private UserService userService;

    @Override
    public LoginResult login(String loginName, String password){
        User user;

        if (RegexUtils.checkMail(loginName)){
            //根据邮箱获取用户
            user = userService.getUserByLoginMail(loginName);
        } else if (RegexUtils.checkMobile(loginName)){
            //根据手机号码获取用户
            user = userService.getUserByLoginMobile(loginName);
        } else {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "邮箱或手机格式不正确");
        }
        if (user == null) {
            //未找到该用户
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            //密码错误
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "密码错误");
        }

        LoginResult result = new LoginResult();
        result.setUserId(user.getUserId());
        result.setRole(user.getRole());
        //result.setToken();
        return result;
    }
}
