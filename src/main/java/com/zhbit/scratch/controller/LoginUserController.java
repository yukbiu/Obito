package com.zhbit.scratch.controller;

import com.zhbit.scratch.base.RestResponse;
import com.zhbit.scratch.base.RestResponseStatus;
import com.zhbit.scratch.domain.result.LoginResult;
import com.zhbit.scratch.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class LoginUserController {
    private static final String LOGIN_URL = "/api/login";

    @Autowired
    private LoginUserService loginUserService;

    @RequestMapping(value = LOGIN_URL,method = RequestMethod.POST)
    public RestResponse<LoginResult> login(@RequestBody Map<String, String> request) {
        LoginResult result = null;

        if (request.containsKey("email")) {
            /*邮箱登录*/
            String loginMail = request.get("email");
            String password = request.get("password");
            result = loginUserService.login(loginMail, password);
        } else if (request.containsKey("mobile")) {
            /*手机号登录*/
            String loginMobile = request.get("mobile");
            String password = request.get("password");
            result = loginUserService.login(loginMobile, password);
        }
        return new RestResponse<>(RestResponseStatus.SUCCESS, result);
    }
}