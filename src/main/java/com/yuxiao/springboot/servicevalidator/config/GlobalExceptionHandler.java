package com.yuxiao.springboot.servicevalidator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yuxiao
 * @date 2020-12-03 17:45
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String superExceptionHandler(Exception e){
        log.info("请求出错:{}", e.getCause().getMessage());
        return e.getCause().getMessage();
    }

}
