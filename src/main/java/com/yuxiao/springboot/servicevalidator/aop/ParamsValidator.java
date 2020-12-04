/*
 * Copyright © 2019, Beijing Jinhaiqunying, Co,. Ltd. All Rights Reserved.
 */

package com.yuxiao.springboot.servicevalidator.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author yuxiao
 * @date 2020-12-03 17:23
 */
@Aspect
@Component
public class ParamsValidator {


    private static Validator validator;

    static {
        validator = Validation.byDefaultProvider().configure()
                .messageInterpolator(new ResourceBundleMessageInterpolator(
                        new PlatformResourceBundleLocator("errorMessages")))
                .buildValidatorFactory().getValidator();
    }


    @Before("@annotation(org.springframework.validation.annotation.Validated)")
    public void before(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Set<ConstraintViolation<Object>> constraintViolations = validator.forExecutables().validateParameters(joinPoint.getThis(), signature.getMethod(), args);
        List<String> messages = new ArrayList<>();
        for (ConstraintViolation<Object> error : constraintViolations) {
            messages.add(error.getMessage());
        }
        if (!messages.isEmpty()) {
            throw new Exception(messages.toString());
        }
    }

}
