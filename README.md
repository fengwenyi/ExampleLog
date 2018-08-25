# spring-boot | 日志

嘿，好久不见，你还好吗？

我一般都是为大家带来项目上比较实用的东西，这次我们来试试项目开发中对日志的处理，希望对你有所帮助。

## 理论知识

1、为什么要用日志？

你是否因为项目出现问题，查找日志文件定位错误花费N多时间，为此苦不堪言？

2、Spring Boot 默认集成Logback。日志输出内容元素具体如下：

* 时间日期：精确到毫秒
* 日志级别：ERROR, WARN, INFO, DEBUG or TRACE
* 进程ID
* 分隔符：— 标识实际日志的开始
* 线程名：方括号括起来（可能会截断控制台输出）
* Logger名：通常使用源代码的类名
* 日志内容

3、日志级别从低到高分为：

    TRACE < DEBUG < INFO < WARN < ERROR < FATAL

4、根据不同的日志系统，你可以按如下规则组织配置文件名，就能被正确加载：

Logback：logback-spring.xml, logback-spring.groovy, logback.xml, logback.groovy
Log4j：log4j-spring.properties, log4j-spring.xml, log4j.properties, log4j.xml
Log4j2：log4j2-spring.xml, log4j2.xml
JDK (Java Util Logging)：logging.properties

Spring Boot官方推荐优先使用带有 `-spring` 的文件名作为你的日志配置（如使用 `logback-spring.xml` ，而不是logback.xml），
命名为logback-spring.xml的日志配置文件，spring boot可以为它添加一些spring boot特有的配置项。

理论知识很重要！！！
虽说实践出真知，但是没有理论做支持，实践只能是盲目的瞎摸，所以，在学好理论的前提下，结合实践，就能更好的为我们服务。

以前在写项目的时候，用的是Log4j，那时候就感觉他很强大，日志滚动啊，日志保存期限啊，设置最大存储量，异常发送邮件，等等功能。
总之，log很强大，他能帮助我们解决很多很多的问题。

## 实际开发

日志功能如此强大，那我们怎么在项目中如何配置，又该如何使用呢？

先申明：
我这里是用Spring Boot搭建的项目，版本是2.x，
有可能你用的是Struts2+Spring+SpringMVC，等等之类的框架搭建。
我想说的是，推荐使用Spring Boot，你也可以将你的SS*项目改成Spring Boot。
如果你有好的建议也可以push给我，我们一起交流，学习。

1、我们先看项目目录：

![项目目录](https://upload-images.jianshu.io/upload_images/5805596-8145594d5e20f875.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2、在 `application.yml`中需要这样配置以下内容：

```yml
spring:
  profiles:
    active: dev
logback:
  appName: examplelog
  fileType: out
```

3、在 `-dev.yml`, `-test.yml`, `-prod.yml` 中需要添加以下配置：

```yml
logback:
  logDir: log/dev

logging:
  level:
    com.fengwenyi.log: debug
    com.fengwenyi.log.service: error
```

4、我们来看一下 `logback-spring.xml` 写法：

请参见源码

5、他有什么功能呢？

* 日志可以输出到指定文件
* 日志可以按运行环境进行输出
* 日志可以按日期进行输出
* 不同包可以指定不同的输出级别

下面我们详细说明一下：

![程序运行环境](https://upload-images.jianshu.io/upload_images/5805596-7e35c6b6e7239fb2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

他会根据你的配置生成对应的目录，来存放相应的日志文档，方便我们查询。比如，开发时，我们看`dev`，测试人员看`test`，上线运行，运维人员看 `prod`，这样的好处是，我们不仅可以方便查询错误定位，也可以设置不同的输出级别。像酱紫

![日志样式](https://upload-images.jianshu.io/upload_images/5805596-997a92d529e0d527.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

是不是很清晰？
另外，他外按日期，每天一个文档，是不是很贴心？
保存多久由你定。
是不是快要感动哭了？
那就 **`star`** 一下吧，谢谢咯。

## API

还是简单说一下配置问题吧：

第一步，你要将 `logback-spring.xml`，放到跟我相同的目录，内容，可以复制过去，也可以适当修改。

第二步，application.yml

```yml
logback:
  appName: examplelog # 日志文件前缀
  fileType: out # 日志后缀名
```

第三步，application-dev.yml，-test.yml，-prod.yml

```yml
logback:
  logDir: log/dev # 日志目录

logging:
  level:
    # 日志级别配置，格式：（包名: 级别）
    com.fengwenyi.log: debug 
    com.fengwenyi.log.service: error
```

## 参考文档

[1] [SpringBoot进阶教程 | 第二篇：日志组件logback实现日志分级打印](https://www.jianshu.com/p/c648e8afb7e2)

[2] [Spring Boot 日志配置(超详细)](https://blog.csdn.net/inke88/article/details/75007649)

