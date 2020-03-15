package com.zhbit.scratch.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;
    private String email;
    private String phone;
    private String password;
    private String role;
}
