package com.zhbit.scratch.base;

import lombok.Getter;
import lombok.Setter;

public enum RestResponseStatus {
    SYSTEM_ERROR("-1", "系统错误"),
    SUCCESS("0", "操作成功");

    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String msg;

    RestResponseStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
