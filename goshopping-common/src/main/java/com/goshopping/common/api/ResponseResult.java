package com.goshopping.common.api;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goshopping.common.constant.StatusCode;
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
@ApiModel(value = "响应结果")
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -6190689122701100762L;

    @ApiModelProperty(value = "响应编码")
    private int code;

    @ApiModelProperty(value = "提示消息")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;

    @JSONField(serialize = false, deserialize = false)  // 不序列化，也不反序列化
    @JsonIgnore                                         // 不包含到返回的json数据中
    public boolean isOk() {
        return this.code == StatusCode.OK.getCode();
    }

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> ok() {
        return ok(null);
    }

    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<T>().code(StatusCode.OK.getCode()).msg(StatusCode.OK.getMessage()).data(data);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult<T>().code(StatusCode.ERROR.getCode()).msg(StatusCode.ERROR.getMessage());
    }

    public static <T> ResponseResult<T> build(int code, String msg) {
        return new ResponseResult<>(code, msg, null);
    }

    public ResponseResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseResult<T> msg(String message) {
        this.msg = message;
        return this;
    }

    public ResponseResult<T> data(T data) {
        this.data = data;
        return this;
    }

}
