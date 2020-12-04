package com.yuxiao.springboot.servicevalidator.service;

import com.yuxiao.springboot.servicevalidator.model.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author yuxiao
 * @date 2020-12-03 17:06
 */
public interface DemoService {

    Map<String, Object> demo(@NotBlank(message = "{param.not.blank}") String params, @Valid User user);
}
