package com.fengwenyi.log.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Wenyi Feng
 */
@Service
@Slf4j
public class LogService {

    public void log () {
        log.error("service error");
        log.info("service info");
    }

}
