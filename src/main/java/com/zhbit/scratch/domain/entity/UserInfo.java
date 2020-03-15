package com.zhbit.scratch.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户个人信息实体类
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;
    private String email;
    private String phone;
    private String sex;
    private String age;
}
