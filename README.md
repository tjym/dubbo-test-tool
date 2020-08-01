# dubbo-test-tool

开发过程中想测试dubbo服务时通常通过dubbo-admin测试。
但是有时第三方dubbo服务不提供dubbo-admin或者dubbo版本较低不支持dubbo-admin测试。此时虽然可以通过telnet测试但是有局限性，自己编写测试工程调用dubbo服务有比较麻烦。
所以写了本项目提供一个dubbo服务的测试工具。计划提供两种方式测试dubbo服务
1. telnet命令测试
2. 导入jar动态加载依赖调用dubbo服务

# 开发计划
开发分两个阶段
1. telnet命令行测试(已完成)
2. 导入jar包测试(开发中)

# 目录结构
bdf 基础开发框架,提供帮助类、基础服务
interface 接口
server 主服务,项目入口

# 功能简介
1. telnet模式
  包括服务管理、方法管理、用例管理。通过根据用例组装telnet命令调用dubbo服务测试
2. pom模式
  编辑pom拉取jar包,直接调用dubbo服务
3. 从dubbo读取已发布服务并解析记录到数据库
4. 从zk拉取注册的服务

# 数据库支持
1. mysql
2. redis

# 启动方式
1. 安装JDK、MAVEN、REDIS/MYSQL、IDEA
2. IDEA导入项目,修改配置
3. DubboTestApplication启动运行

# 开发环境
jdk 1.8
maven 3.3.9
dubbo 2.6.5
redis 3.9
mysql 5.7
fastjosn 1.2.70
lombok 1.16.22
idea 2020
windows 10
