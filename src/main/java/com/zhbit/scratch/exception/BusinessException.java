package com.zhbit.scratch.exception;

import lombok.Getter;
import lombok.Setter;

public class BusinessException extends RuntimeException {
    @Setter
    @Getter
    private String code;
    @Setter
    @Getter
    private String msg;

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
