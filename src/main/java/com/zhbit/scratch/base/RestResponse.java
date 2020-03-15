package com.zhbit.scratch.base;

import lombok.Data;

@Data
public class RestResponse<T> {
    private String code;
    private String msg;
    private T data;

    public RestResponse() {
    }

    public RestResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(RestResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public RestResponse(RestResponseStatus status,T data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }
}