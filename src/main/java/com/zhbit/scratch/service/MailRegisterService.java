package com.zhbit.scratch.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 用户正常注册
 */
@Transactional
public interface MailRegisterService extends RegisterService{
    //邮箱注册
    void register(String loginMail, String password, String role);
}
