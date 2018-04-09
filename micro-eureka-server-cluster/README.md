# micro-eureka-server-cluster 
当成千上万个服务向服务注册中心Eureka Server注册的时候，它的负载是非常高的，这在生产环境上是不太合适的，这篇文章主要介绍怎么将    Eureka Server集群化。

###  结构视图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/180428_4566e4e6_1468963.png "eureka-3.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/175315_f45e33da_1468963.png "eureka-1.png")
![输入图片说明](https://git.oschina.net/uploads/images/2017/0904/175324_79b781ee_1468963.png "eureka-2.png")


#
启动时，通过spring.profiles.active属性来分别启动peer1和peer2
java -jar micro-eureka-server-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar micro-eureka-server-cluster-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2

    #################################################################
    ###################### eureka 注册中心 ###########################
    ################################################################
    
    spring:
      application:
    name: EurekaServer
    
    server:
      port: 8112
    #  port: ${PORT:${SERVER_PORT:0}}
    
    security:
      basic:
    enabled: true # 启用认证
      user:
    name: lishangzhi
    password: 123456
    
    
    eureka:  
      instance: 
    hostname: localhost
      client: 
    registerWithEureka: false
    fetchRegistry: false   
    serviceUrl: 
      defaultZone: http://lishangzhi:123456@localhost:8111/eureka/

<br>

    #############################################################
    ###################### eureka 注册中心 #######################
    #############################################################
    
    spring:
      application:
    name: EurekaServer
    
    server:
      port: 8112
    #  port: ${PORT:${SERVER_PORT:0}}
    
    security:
      basic:
    enabled: true # 启用认证
      user:
    name: lishangzhi
    password: 123456
    
    
    eureka:  
      instance: 
    hostname: localhost
      client: 
    registerWithEureka: false
    fetchRegistry: false   
    serviceUrl: 
      defaultZone: http://lishangzhi:123456@localhost:8111/eureka/

    


    




