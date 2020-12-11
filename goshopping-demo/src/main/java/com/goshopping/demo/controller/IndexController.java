package com.goshopping.demo.controller;

import com.goshopping.common.api.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yujianzhong
 * @date 2020/12/11
 */
@Api(tags = "首页模块")
@RestController
@RefreshScope
public class IndexController {

    @Value("${service.name}")
    private String serverName;

    @ApiOperation("向客人问好")
    @GetMapping("/sayHi")
    public ResponseResult<String> sayHi() {
        return ResponseResult.success("Hi:" + serverName);
    }
}