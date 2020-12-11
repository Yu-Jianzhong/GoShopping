# GoShopping

GoShopping是一个基于mall改造的电商系统

## 项目结构

``` lua
Goshopping
├── goshopping-common -- 工具类及通用代码模块
├── goshopping-mbg -- MyBatisGenerator生成的数据库操作代码模块
├── goshopping-auth -- 基于Spring Security Oauth2的统一的认证中心
├── goshopping-gateway -- 基于Spring Cloud Gateway的微服务API网关服务
├── goshopping-monitor -- 基于Spring Boot Admin的微服务监控中心
├── goshopping-admin -- 后台管理系统服务
├── goshopping-search -- 基于Elasticsearch的商品搜索系统服务
├── goshopping-portal -- 移动端商城系统服务
├── goshopping-demo -- 微服务远程调用测试服务
└── config -- 配置中心存储的配置
```