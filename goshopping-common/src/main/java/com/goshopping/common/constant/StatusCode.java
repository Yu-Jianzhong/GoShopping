package com.goshopping.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义返回码
 *
 * @author yujianzhong
 * @date 2020/4/18
 */
@Getter
public enum StatusCode {
    /**
     * 无权访问，非本人数据；或者数据不存在
     */
    NO_ACCESS(4404, "找不到对应数据！"),

    /**
     * 远程调用失败
     */
    REMOTE_FAIL(4500, "系统繁忙，请稍后重试"),

    /**
     * 数据被占用
     */
    DATA_OPERATED_BY_ORDER(4501, "操作超时，请您重试！"),

    /**
     * 非法参数
     */
    ILLEGAL_PARAMETER(405, "输入值有误，请检查再输入！"),

    VISIT_LIMIT(405, "请求繁忙，请稍后再试!"),

    // 订单相关
    GOODS_STOCK_MORE_THAN(4801, "库存不足"),
    GOODS_NOT_EXIST(4802, "商品已下架"),
    COUPON_UNAVAILABLE(4810, "部分优惠券已使用/不可使用"),

    TRADE_SECKILL_WAIT(4840, "正在排队中........"),

    TRADE_NOT_EXIST(4850, "订单不存在"),
    TRADE_GOODS_NOT_EXIST(4851, "子订单不存在"),
    TRADE_REFUND_HAS_APPLY(4852, "订单已发起过售后"),
    TRADE_IS_PLAY(4859, "订单已支付"),

    TRADE_MUST_APPLY(4899, "订单无法直接取消，需走售后渠道"),

    /**
     * 数据已更新过
     */
    DATA_HAD_UPDATE(406, "数据已更新过/已存在"),

    /**
     * 未达到业务条件（弹窗）
     */
    CONDITION_NOT_REACHED(407, "未达到业务条件（弹窗）"),
    /**
     * 未达到业务条件（弹窗）,微信
     */
    CONDITION_NOT_REACHED_WX(408, "未达到业务条件（弹窗）"),

    /**
     * 注册成功
     */
    REGISTER_SUCCESS(200, "注册成功，请前往登录"),

    /**
     * 发送太频繁,60秒只能发送一次
     */
    SEND_VERIFICATION_TOO_FAST(602, "发送太频繁,60秒只能发送一次"),

    /**
     * 请先获取验证码
     */
    NO_SEND_VERIFICATION_CODE_INVALID(1000, "请先获取验证码"),

    /**
     * 验证码过期或没有发送
     */
    VERIFICATION_CODE_INVALID(1000, "验证码已失效"),

    /**
     * 验证码错误
     */
    VERIFICATION_CODE_ERROR(1000, "验证码错误，请重新输入"),

    /**
     * 密码错误
     */
    LOGIN_PASSWORD_ERROR(1000, "密码错误"),

    /**
     * 账号不存在
     */
    LOGIN_USER_NULL(1000, "您还没有注册,请用验证码登录"),

    /**
     * 用户禁用
     */
    ACCOUNT_DISABLED(997, "未经授权，请联系客服"),

    /**
     * 用户登录token为空
     */
    ACCOUNT_TOKEN_EMPTY(998, "用户登录token不能为空"),

    /**
     * 账号不存在或登录已失效
     */
    ACCOUNT_NOT_EXIST(999, "账号不存在或登录已失效"),

    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 失败
     */
    FAIL(500, "fail"),

    // 第三方接口调用错误
    REMOTE_API_ERROR(4100, "第三方接口调用错误"),

    /**
     * 系统错误
     */
    ERROR(5000, "网络开小差，请稍后重试"),
    /**
     * 事务错误
     */
    TRANSACTIONAL_ERROR(5001, "事务错误"),

    ;


    private int code;
    private String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
