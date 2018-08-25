package com.fengwenyi.log;

import com.fengwenyi.log.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wenyi Feng
 */
@RestController
@Slf4j
public class TestLogController {

    @Autowired
    private LogService logService;

    @RequestMapping("log")
    public String log(HttpServletRequest request) {
        log.info("sessionid : {}", request.getRequestedSessionId());
        log.info("日志输出：info");
        log.debug("日志输出：debug");
        log.warn("日志输出：warn");
        log.error("日志输出：error");

        log.info("拼接-日志输出：{}", "info");
        log.debug("拼接-日志输出：{}", "debug");
        log.warn("拼接-日志输出：{}", "warn");
        log.error("拼接-日志输出：{}", "error");

        logService.log();

        return "1";
    }

}
