package com.zhbit.scratch.handler;

import com.zhbit.scratch.base.RestResponse;
import com.zhbit.scratch.base.RestResponseStatus;
import com.zhbit.scratch.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {
    //处理所有不可知的异常
    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    public <T> RestResponse<T> exceptionHandler(Exception e){
        //logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new RestResponse<>(RestResponseStatus.SYSTEM_ERROR);
    }

//     自定义异常的捕获
//     自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。

    @ExceptionHandler(value={BusinessException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> RestResponse<T> sendError(BusinessException exception, HttpServletRequest request){
        //String requestURI = request.getRequestURI();
        //logger.error("occurs error when execute url ={} ,message {}",requestURI,exception.getMsg());
        return new RestResponse<>(exception.getCode(),exception.getMsg());
    }

}
