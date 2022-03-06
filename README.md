GoShopping是一个微服务B2B2C电商商城系统


## 目录结构

``` lua
GoShopping
├─goshopping-api -- 内网接口
│  ├─goshopping-api-auth  -- 授权对内接口
│  ├─goshopping-api-biz  -- biz对内接口
│  ├─goshopping-api-leaf  -- 美团分布式id生成接口
│  ├─goshopping-api-multishop  -- 店铺对内接口
│  ├─goshopping-api-order  -- 订单对内接口
│  ├─goshopping-api-platform  -- 平台对内接口
│  ├─goshopping-api-product  -- 商品对内接口
│  ├─goshopping-api-rbac  -- 用户角色权限对内接口
│  ├─goshopping-api-search  -- 搜索对内接口
│  └─goshopping-api-user  -- 用户对内接口
├─goshopping-auth  -- 授权校验模块
├─goshopping-biz  -- 业务代码。如图片上传/短信等
├─goshopping-common -- 一些公共的方法
│  ├─goshopping-common-cache  -- 缓存相关公共代码
│  ├─goshopping-common-core  -- 公共模块核心（公共中的公共代码）
│  ├─goshopping-common-database  -- 数据库连接相关公共代码
│  ├─goshopping-common-order  -- 订单相关公共代码
│  ├─goshopping-common-product  -- 商品相关公共代码
│  ├─goshopping-common-rocketmq  -- rocketmq相关公共代码
│  └─goshopping-common-security  -- 安全相关公共代码
├─goshopping-gateway  -- 网关
├─goshopping-leaf  -- 基于美团leaf的生成id服务
├─goshopping-multishop  -- 商家端
├─goshopping-order  -- 订单服务
├─goshopping-payment  -- 支付服务
├─goshopping-platform  -- 平台端
├─goshopping-product  -- 商品服务
├─goshopping-rbac  -- 用户角色权限模块
├─goshopping-search  -- 搜索模块
└─goshopping-user  -- 用户服务
```



## 技术选型

### 后端技术

| 技术               | 说明             |
| :----------------- | :--------------- |
| SpringBoot         | 容器+MVC框架     |
| SpringCloud        | 分布式框架       |
| SpringCloudAlibaba | 分布式框架       |
| MySQL              | 数据库           |
| MyBatisPlus        | 数据库访问框架   |
| ElasticSearch      | 搜索引擎         |
| RocketMQ           | 消息队列         |
| Redis              | 分布式缓存       |
| Knife4j            | 文档             |
| Hutool             | 工具类           |
| Lombok             | 简化对象封装工具 |

