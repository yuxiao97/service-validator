package com.yuxiao.springboot.servicevalidator.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * @author yuxiao
 * @date 2020-12-03 17:08
 */
@Data
public class User implements Serializable {

    @NotBlank(message = "{param.not.blank}")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Positive(message = "{param.must.positive}")
    private Integer age;

}
