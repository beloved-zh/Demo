package com.beloved;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JCLTest {

    @Test
    public void test01() {
        // log 日志记录器
        Log log = LogFactory.getLog(JCLTest.class);

        // 日志记录输出
        log.info("hello jcl");
    }

}
