package com.zhbit.scratch.domain.result;

import lombok.Data;

/**
 * 获取验证码返回值
 */
@Data
public class GetCodeResult {

    private String email;
    private String code;
}
