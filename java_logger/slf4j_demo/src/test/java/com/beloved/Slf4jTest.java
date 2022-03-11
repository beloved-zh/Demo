package com.beloved;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    /**
     * 快速入门
     */
    @Test
    public void test01() {
        // 日志输出
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");        // 默认级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        // 占位符输出
        LOGGER.info("name：{}", "张三");

        // 输出系统异常信息
        try {
            int i = 10 / 0;
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error("发生异常：{}", e.getMessage());
        }
    }
}
