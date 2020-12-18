package com.goshopping.common.exception;

import com.goshopping.common.api.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @author yujianzhong
 * @date 2020/12/18
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseResult<Object> exceptionHandler(Exception exception) {
        return ResponseResult.failed(exception.getMessage());
    }
}
