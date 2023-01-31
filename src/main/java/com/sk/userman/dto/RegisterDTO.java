package com.sk.userman.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "注册实体类")
public class RegisterDTO {

    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 姓
     */
    @NotBlank(message = "姓不能为空")
    private String firstName;

    /**
     * 名
     */
    @NotBlank(message = "名不能为空")
    private String lastName;
}
