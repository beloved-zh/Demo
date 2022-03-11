
logback主要模块：
- logback-core：核心基础模块
- logback-classic：是log4j的改良版本，实现了完整的slf4j API
- logback-access：访问模块与Servlet容器集成提供通过Http访问日志功能


logback默认加载配置文件（均不存在采用默认配置）：
1. logback.groovy
2. logback-test.xml
3. logback.xml

logback组件：
- Logger：日志记录器，关联到应用的context上后，主要用于存放日志对象，也可自定义日志类型、级别
- Appender：用于指定日志输出的目的地。控制台、文件、数据库等
- Layout：负责吧事件转换成字符串，格式化日志信息输出。在logback中Layout对象被封装在encoder中。

官方log4j转logback日志配置转换器：https://logback.qos.ch/translator/


