package com.beloved;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Log4jTest {

    /**
     * 快速入门
     */
    @Test
    public void test01() {
        // 初始化配置信息，使用配置文件
//        BasicConfigurator.configure();

        // 开启 log4j 内置日志记录
        LogLog.setInternalDebugging(false);

        // 获取日志记录器
        Logger logger = Logger.getLogger(Log4jTest.class);

        // 输出
        logger.info("hello log4j");
        // 级别
        logger.fatal("fatal");  // 严重错误，一般会造成系统崩溃并终止运行
        logger.error("error");  // 错误信息，不会影响系统运行
        logger.warn("warn");    // 警告信息，可能发生问题
        logger.info("info");    // 运行信息，数据连接，IO等
        logger.debug("debug");  // 调式信息，一般在开发中使用，变量等
        logger.trace("trace");  // 追踪信息，记录程序所有流程信息
    }


    /**
     * 循环文件写入
     */
    @Test
    public void test02() {

        // 获取日志记录器
        Logger logger = Logger.getLogger(Log4jTest.class);

        for (int i = 0; i < 10000; i++) {
            // 输出
            logger.fatal("fatal---" + i);
            logger.error("error---" + i);
            logger.warn("warn---" + i);
            logger.info("info---" + i);
            logger.debug("debug---" + i);
            logger.trace("trace---" + i);
        }
    }

}
