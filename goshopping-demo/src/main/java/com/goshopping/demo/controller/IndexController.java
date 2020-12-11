package com.goshopping.demo.controller;

import com.goshopping.common.api.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yujianzhong
 * @date 2020/12/11
 */
@Api(tags = "首页模块")
@RestController
public class IndexController {

    @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation("向客人问好")
    @GetMapping("/sayHi")
    public ResponseResult<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseResult.success("Hi:" + name);
    }
}