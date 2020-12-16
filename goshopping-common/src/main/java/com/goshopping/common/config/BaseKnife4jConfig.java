package com.goshopping.common.config;

import com.goshopping.common.entity.Knife4jProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 基础Knife4j API文档配置，其他服务的文档配置需继承此类
 *
 * @author yujianzhong
 * @date 2020/12/11
 */
public abstract class BaseKnife4jConfig {
    @Bean
    public Docket createRestApi() {
        Knife4jProperties knife4jProperties = knife4jProperties();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(knife4jProperties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(knife4jProperties.getApiBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(Knife4jProperties knife4jProperties) {
        return new ApiInfoBuilder()
                .title(knife4jProperties.getTitle())
                .description(knife4jProperties.getDescription())
                .contact(new Contact(knife4jProperties.getContactName(), knife4jProperties.getContactUrl(), knife4jProperties.getContactEmail()))
                .version(knife4jProperties.getVersion())
                .build();
    }

    /**
     * 自定义Swagger配置
     */
    public abstract Knife4jProperties knife4jProperties();
}
