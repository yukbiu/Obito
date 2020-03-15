package com.zhbit.scratch.domain.result;

import lombok.Data;

/**
 * 用户登录返回值
 */
@Data
public class LoginResult {

    private String userId;
    private String role;
    private String token;
}
