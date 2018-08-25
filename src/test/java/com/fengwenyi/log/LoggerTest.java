package com.fengwenyi.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @author Ben.WF
 */
@Component
@Slf4j
public class LoggerTest extends LogApplicationTests {

    @Test
    public void test1() {
        // 日志由低到高输出：
        // TRACE < DEBUG < INFO < WARN < ERROR < FATAL
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");

        String name = "name";
        log.info("日志输出拼接：{}", name);
    }

}
