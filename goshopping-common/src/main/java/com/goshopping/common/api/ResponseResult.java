package com.goshopping.common.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应结果
 *
 * @author yujianzhong
 * @date 2020/4/28
 */
@Data
@NoArgsConstructor
@ApiModel("响应结果")
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -6190689122701100762L;

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "提示消息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == StatusCode.SUCCESS.getCode();
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>().code(StatusCode.SUCCESS.getCode()).message(StatusCode.SUCCESS.getMessage());
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>().code(StatusCode.SUCCESS.getCode()).message(StatusCode.SUCCESS.getMessage()).data(data);
    }

    public static <T> ResponseResult<T> failed() {
        return new ResponseResult<T>().code(StatusCode.FAILED.getCode()).message(StatusCode.FAILED.getMessage());
    }

    public static <T> ResponseResult<T> failed(String message) {
        return new ResponseResult<T>().code(StatusCode.FAILED.getCode()).message(message);
    }

    public static <T> ResponseResult<T> build(int code, String message) {
        return new ResponseResult<T>(code, message, null);
    }

    public static <T> ResponseResult<T> build(int code, String message, T data) {
        return new ResponseResult<>(code, message, data);
    }

    public ResponseResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseResult<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseResult<T> data(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
