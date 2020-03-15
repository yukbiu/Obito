package com.zhbit.scratch.service;

import com.zhbit.scratch.domain.result.LoginResult;

public interface LoginUserService {
/**
 * 用户登录
 */
     LoginResult login(String loginName, String password);

}
