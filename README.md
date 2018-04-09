#micro-services
标签（空格分隔）： 微服务 SpringCloud Dubbo

---
Spring Cloud 快速搭建微服务

<br>
spring cloud 为开发人员提供了快速构建分布式系统的一些工具，本框架包括配置管理、服务发现、断路器、路由、微代理、分布式会话、OAuth2服务、服务链路追踪、RestAPI等等，下面进行个服务分部搭建源码与测试案例，此项目初于学习迭代商有待深入了解！

<br>

---
##目标微服务系统

![SpringCloud组件](https://raw.githubusercontent.com/wzg923/micro-service/master/doc/image/springcloud-1.png "springcloud-1.png")



## 组织结构



	micro-services
	├── cloud-admin 
	├── micro-config-server --  分布式配置中心（高可用的分布式配置中心）(Spring Cloud Config)
	├── micro-discovery -- Netflix Eureka服务注册中心    [端口 8761]
	├── micro-eureka-server-cluster -- Netflix Eureka服务注册中心集群    [端口 peer1:8111 peer2:8112]
	├── micro-dubbo-proxy -- Dubbo Proxy网关
	├── micro-graphite
	├── micro-hystrix -- 断路器Hystrix Dashboard(Hystrix 仪表盘)
	├── micro-oauth2
	|   ├── oauth2-server -- AuthorizationServer[OAuth2服务]
	|   ├── oauth-ui -- Zuul网关 OAuth2Sso 
	|   ├── oauth2-resource -- 访问授权资源
	├── micro-user-parent -- 用户服务模块(模拟服务)
	|	├── micro-user-service-interface -- 用户服务API 
	|	├── micro-user-service -- 用户服务暴露服务[端口 8079] 
	├─── micro-user-ui-parent -- 用户服务调用分发
	|	├── micro-user-ui-dubbo -- dubbo消费者调用dubbo服务
	|	├── micro-user-ui-dubbo-proxy -- dubbo服务代理
	|	├── micro-user-ui-feign -- 服务分发（feign）（内嵌ribbon负载均衡）
	|	├── micro-user-ui-ribbon -- 服务分发（rest+ribbon）负载均衡调用服务
	|	├── micro-user-ui-zuul-proxy -- zuul路由网关
    ├─── micro-zuul-server -- zuul路由网关
    ├─── micro-server-zipkin  -- zipkin数据收集中心  [端口 8501]




作者：王振广
链接：https://github.com/wzg923/micro-service.git
來源：GitHub
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
