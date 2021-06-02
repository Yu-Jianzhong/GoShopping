package com.goshopping.demo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.goshopping.common.entity.Knife4jProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j API文档配置
 *
 * @author yujianzhong
 * @date 2020/12/16
 */
@Configuration
@EnableKnife4j
public class Knife4jConfig extends BaseKnife4jConfig {
    @Override
    public Knife4jProperties knife4jProperties() {
        return Knife4jProperties.builder()
                .apiBasePackage("com.goshopping.demo.controller")
                .title("测试服务")
                .description("测试服务")
                .contactName("yujianzhong")
                .version("1.0")
                .build();
    }
}
