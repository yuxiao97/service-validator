package com.yuxiao.springboot.servicevalidator.service.impl;

import com.yuxiao.springboot.servicevalidator.model.User;
import com.yuxiao.springboot.servicevalidator.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuxiao
 * @date 2020-12-03 17:06
 */
@Service
public class DemoServiceImpl implements DemoService {


    @Validated
    @Override
    public Map<String, Object> demo(String params, User user) {
        HashMap<String, Object> o = new HashMap<>(3);
        o.put("params", params);
        o.put("name", user.getName());
        o.put("age", user.getAge());
        return o;
    }
}
