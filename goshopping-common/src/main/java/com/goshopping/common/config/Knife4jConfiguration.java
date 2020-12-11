package com.goshopping.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Knife4j API文档配置
 *
 * @author yujianzhong
 * @date 2020/12/11
 */
@Configuration
@EnableKnife4j
public class Knife4jConfiguration {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("GoShopping API接口文档")
                        .description("GoShopping API接口文档")
                        .termsOfServiceUrl("localhost")
                        .contact(new Contact("yujianzhong", "localhost", "1120384609@qq.com"))
                        .version("1.0")
                        .build())
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.goshopping"))
                .paths(PathSelectors.any())
                .build();
    }
}
