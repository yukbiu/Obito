package com.zhbit.scratch.service;

/**
 * 用户注册
 */
public interface RegisterService {
    //根据登录名查找用户是否存在
    boolean checkLoginName(String loginName);
}
