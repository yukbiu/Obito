package com.zhbit.scratch.service.impl;

import com.zhbit.scratch.Utils.IdUtils;
import com.zhbit.scratch.base.HttpStatus;
import com.zhbit.scratch.base.NumberConstant;
import com.zhbit.scratch.domain.entity.User;
import com.zhbit.scratch.exception.BusinessException;
import com.zhbit.scratch.service.MailRegisterService;
import com.zhbit.scratch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户邮箱注册实现
 */
@Service
public class MailRegisterServiceImpl implements MailRegisterService {

    @Autowired
    private UserService userService;

    @Override
    public void register(String loginMail, String password, String role) {

        if (this.checkLoginName(loginMail)) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "该邮箱已注册");
        }

        User user = new User();
        user.setUserId(IdUtils.getPrimaryKey());
        user.setEmail(loginMail);
        user.setPassword(password);
        user.setRole(role);
        userService.addUser(user);

    }

    @Override
    public boolean checkLoginName(String loginMail) {
        int count = this.userService.countByLoginMail(loginMail);
        return count > NumberConstant.Int.INT_ZERO;
    }
}
