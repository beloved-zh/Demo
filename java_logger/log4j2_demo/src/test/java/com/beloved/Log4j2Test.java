package com.beloved;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {

    // 日志记录器
    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

    @Test
    public void test01() {
        // 日志输出
        LOGGER.fatal("fatal");
        LOGGER.error("error");      // 默认级别
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

}
