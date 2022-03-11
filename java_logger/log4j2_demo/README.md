log4j2其实也是日志门面，因为日志实现功能强大、性能优越。所以一般还是将log4j2看作日志实现，主流方案：slf4j + log4j2

```xml
<!-- slf4j 门面 -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>

<!-- slf4j log4j2 适配器-->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.14.1</version>
</dependency>

<!-- log4j2 日志门面-->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.14.1</version>
</dependency>
<!-- log4j2 日志实现 -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.14.1</version>
</dependency>
```


**异步日志**

log4j2提供了两种实现异步日志的方式：
- AsyncAppender
  ```xml
    <Appenders>
      <File name="file" fileName="${LOG_HOME}/log4j2.log">
          <PatternLayout charset="UTF-8" pattern="%d %t [%p] - [%l] - %m%n"/>
      </File>

      <!-- 异步实现：AsyncAppender-->
      <Async name="async">
          <AppenderRef ref="file" />
      </Async>
  </Appenders>
  <Loggers>
      <Root level="trace">
          <!-- 使用异步 Appender -->
          <AppenderRef ref="async" />
      </Root>
  </Loggers>
  ```
- AsyncLogger（推荐）
  - **全局异步：** 所有的日志都是异步的记录，在配置文件上不用做任何改动，只需要添加`log4j2.component.properties`配置。
    ```prop
    Log4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
    ```
    
  - **混合（局部）异步：** 在应用中同时使用同步日志和异步日志，配置方式更灵活。
    ```xml
    <Loggers>
      <!--
          自定义异步 logger 对象
               includeLocation="false"    关闭日志记录行号，开启会影响应能
               additivity="false"         不继承 RootLogger 对象
      -->
      <AsyncLogger name="com.beloved" level="trace" includeLocation="false" additivity="false">
        <AppenderRef ref="console" />
      </AsyncLogger>

      <Root level="trace">
        <AppenderRef ref="file" />
      </Root>
    
      <!-- com.beloved：异步日志    root：同步日志 -->
    </Loggers>
    ```
使用异步日志注意：
- 使用异步日志，AsyncAppender、AsyncLogger和全局日志，不要同时出现。性能会和AsyncAppender一致，降至最低。
- 设置includeLocation="false"，打印位置信息会急剧降低异步日志的性能，比同步日志还要慢。



注意：异步日志需要添加依赖
```xml
<!-- 异步日志依赖 -->
<dependency>
    <groupId>com.lmax</groupId>
    <artifactId>disruptor</artifactId>
    <version>3.4.4</version>
</dependency>
```



