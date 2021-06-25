# HuaGieProject
花Gie博客中设计到的项目都会在这个工程中进行维护

##项目介绍
1. Nacos配置中心

如果只是需要测试Nacos配置中心功能，只需要启动`nacos-consumer`服务即可，启动前注释`ConsumerController`中`getDubboResult`相关代码。

2 Nacos配置中心功能

* nacos-api使用命令或idea打成 **jar** 包
* 在`nacos-consumer`、 `nacos-provider`中分别导入上述jar包
* 下载并启动nacos服务，浏览器通过`http://192.168.99.12:8848/nacos/index.html`即可进入控制台
* 启动`nacos-consumer`、 `nacos-provider`服务
* 调用`nacos-consumer`接口`getDubboResult`进行调试

ps:Nacos安装方法见博文https://juejin.cn/post/6977017721334530084