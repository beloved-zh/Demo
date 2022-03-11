package com.beloved;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 桥接器测试
 */
public class Log4jTest {

    public static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    @Test
    public void test01() {
        LOGGER.info("Log4jTest~~~");
    }
}
