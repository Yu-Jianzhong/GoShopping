package com.goshopping.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义返回码
 *
 * @author yujianzhong
 * @date 2020/4/18
 */
@AllArgsConstructor
@Getter
public enum StatusCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    VALIDATE_FAILED(404, "参数检验失败"),
    ;
    private int code;
    private String message;
}
