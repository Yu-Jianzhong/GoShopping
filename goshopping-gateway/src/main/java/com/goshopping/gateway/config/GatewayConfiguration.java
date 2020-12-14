package com.goshopping.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 网关配置
 *
 * @author yujianzhong
 * @date 2020/4/28
 */
@Configuration
public class GatewayConfiguration {
    @Bean
    @Order
    public RouteLocator customizedRoutes(RouteLocatorBuilder builder) {
        //配置路由路径
        return builder.routes()
                // 后台管理系统服务
                .route(r -> r.path("/goshopping-admin/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://goshopping-admin"))
                // 认证中心
                .route(r -> r.path("/goshopping-auth/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://goshopping-auth"))
                // 测试服务
                .route(r -> r.path("/goshopping-demo/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://goshopping-demo"))
                // 移动端商城系统服务
                .route(r -> r.path("/goshopping-portal/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://goshopping-portal")
                )
                // 搜索系统服务
                .route(r -> r.path("/goshopping-search/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://goshopping-search")
                )
                .build();
    }
}
