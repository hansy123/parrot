# springcloud-study
springcloud-study
springboot版本2.1.8
springcloud版本Greenwich.SR3
本项目没有采用vo po dto等概念，统一使用bean概念
数据库为MySQL和redis
没有集成熔断器组件

结构目录
springcloud-study -- 是一个pom工程 将来会更改为springcloud-parent
    eureka-server -- 服务注册中心 port:9001 actuator端口8001
    parrot-api -- server共有的bean和api接口 
    parrot-server -- 学生服务项目 端口:9002 actuator端口8002
    parrot-clazz-server -- 班级服务项目集成feign 端口:9003 actuator端口8003
    zuul-server -- 网关服务 端口:9004 actuator端口8004
    config-server -- 配置中心 port:9005 actuator端口8005
    zikpin-server -- 链路追踪 port:9006 actuator端口8006
    sql -- sql脚本

eureka-server，parrot-server，parrot-clazz-server，zuul-server均集成了配置中心，bus配置刷新功能
parrot-server，parrot-clazz-server 集成了feign组件

坑1：配置中心，spring.application.name值是git配置文件的application名称，不能带中间-
坑2：bus配置刷新，集成的是rabbitmq，由于本地环境中activemq服务处于开启状态，报mismatch错
坑3：zipkin web界面，服务名始终无法匹配，添加配置spring.sleuth.sampler.probability=1.0 全部采样。该值默认0.1（10%）


配置刷新：url:http://localhost:8003/actuator/bus-refresh post请求
链路追踪地址：http://localhost:9006/zipkin/
tx-lcn事务客户端：http://localhost:5001


设想：eureka-server与config-server，zipkin-server可以合并为一个项目

sql脚本后期会使用插件进行管理

MyCat id字段必须是bigint
读写分离配置参数说明：
balance:
    1. balance=“0”, 所有读操作都发送到当前可用的writeHost上。
    2. balance=“1”，所有读操作都随机的发送到readHost。
　　3. balance=“2”，所有读操作都随机的在writeHost、readhost上分发
    4. balance=“3”所有读请求随机的分发到 wiriterHost 对应的 readhost 执行,writerHost 不负担读压力
WriteType:
    1. writeType=“0”, 所有写操作都发送到可用的writeHost上。
　　2. writeType=“1”，所有写操作都随机的发送到readHost。
  　3. writeType=“2”，所有写操作都随机的在writeHost、readhost分上发。
switchType:
    1.默认值，自动切换
　　2.基于MySQL主从同步的状态决定是否切换
    3
