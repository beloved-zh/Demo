package com.beloved;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

    @Test
    void contextLoads() {
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");        // 默认级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        // 使用 log4j2 使用桥接器切换为 slf4j 门面和 logback 日志实现
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(SpringBootDemoApplicationTests.class);

        logger.info("log4j2 info");
    }

}
