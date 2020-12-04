package com.yuxiao.springboot.servicevalidator.controller;

import com.yuxiao.springboot.servicevalidator.model.User;
import com.yuxiao.springboot.servicevalidator.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yuxiao
 * @date 2020-12-03 17:06
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("demo")
    public Map<String, Object> demo(String params, User user) {
        return demoService.demo(params, user);
    }
}
