package com.goshopping.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger资源配置
 *
 * @author yujianzhong
 * @date 2020/4/30
 */
@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {
    public static final String API_URI = "/v2/api-docs";
    public static final String SUB_PRIX = "ReactiveCompositeDiscoveryClient_";

    private final DiscoveryClientRouteDefinitionLocator routeLocator;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        routeLocator.getRouteDefinitions().subscribe(routeDefinition -> {
            // 不将网关加入到swagger
            if (!routeDefinition.getId().contains("gateway")) {
                resources.add(swaggerResource(routeDefinition.getId().substring(SUB_PRIX.length()), routeDefinition.getPredicates().get(0).getArgs().get("pattern").replace("/**", API_URI)));
            }
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
