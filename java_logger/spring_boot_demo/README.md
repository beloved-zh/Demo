SpringBoot默认使用slf4j作为日志门面，logback作为日志实现来记录日志
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```

- SpringBoot底层默认使用logback作为日志实现
- 使用slf4j作为日志门面
- 将jul也转换slf4j
- 也可以使用log4j2作为日志门面，但最终也是通过slf4j调用logback

配置文件

|   日志框架   |   配置文件   |
| ---- | ---- | 
|   logback   |   logback-spring.xml、logback.xml   | 
|   log4g2   |   log4g2-spring.xml、log4j2.xml   | 
|   jul   |   logging.properties   | 

**SpringBoot解析日志配置**
logback-spring.xml：由SpringBoot解析日志配置
```xml
<encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
    <springProfile name="dev">
        <pattern>${pattern}</pattern>
    </springProfile>
    <springProfile name="pro">
        <pattern>%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n</pattern>
    </springProfile>
</encoder>
```
可以切换项目环境
```properties
# 指定环境
spring.profiles.active = pro
```

**切换日志实现为log4j2**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <!-- 排除 logback -->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- 添加 log4j2 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
