package com.beloved;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class JULTest {

    /**
     * 快速入门
     */
    @Test
    public void test01 () {
        // 获取日志记录器
        Logger logger = Logger.getLogger("com.beloved.JULTest");
        // 日志输出
        logger.info("hello jul");

        // 通用方法日志输出
        logger.log(Level.INFO, "info msg");

        // 占位符输出变量
        logger.log(Level.INFO, "输出信息：{0}，{1}",new Object[]{"张三", 18});
    }

    /**
     * 日志级别
     */
    @Test
    public void test02() {
        Logger logger = Logger.getLogger("com.beloved.JULTest");

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");    // jul默认日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * 自定义日志级别
     */
    @Test
    public void test03() throws IOException {
        Logger logger = Logger.getLogger("com.beloved.JULTest");

        // 关闭系统默认配置
        logger.setUseParentHandlers(false);

        // 创建 ConsoleHandler  控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建时间格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        // 配置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 文件输出
        FileHandler fileHandler = new FileHandler("D://logs/JULTest_test03.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");    // jul默认日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * Logger对象父子关系
     */
    @Test
    public void test04() {
        Logger logger1 = Logger.getLogger("com");
        Logger logger2 = Logger.getLogger("com.beloved");

        System.out.println(logger1 == logger2.getParent());

        // 日志记录器顶级父元素 LogManager$RootLogger    name：""  空字符串
        System.out.println("logger1 Parent：" + logger1.getParent() + "，name：" + logger1.getParent().getName());

        // 设置logger1的日志级别
        logger1.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger1.addHandler(consoleHandler);
        logger1.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 日志记录器会继承父的日志级别
        logger2.severe("severe");
        logger2.warning("warning");
        logger2.info("info");    // jul默认日志级别
        logger2.config("config");
        logger2.fine("fine");
        logger2.finer("finer");
        logger2.finest("finest");
    }

    /**
     * 加载自定义文件
     */
    @Test
    public void test05() throws IOException {

        // 通过类加载器读取配置文件
        InputStream inputStream = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");

        // 创建LogManager
        LogManager logManager = LogManager.getLogManager();
        // 通过LogManager加载配置文件
        logManager.readConfiguration(inputStream);

        Logger logger = Logger.getLogger("com.beloved.JULTest");

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");    // jul默认日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}
