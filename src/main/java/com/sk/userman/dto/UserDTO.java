package com.sk.userman.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @author: zsc
 * @create: 2023-01-29 22:29
 **/
@Data
@ApiModel(value = "修改实体类")
public class UserDTO {
    @Null(message = "用户id不可修改")
    @ApiModelProperty(value = "id")
    private Integer id;

    @NotBlank(message = "姓不能为空")
    @ApiModelProperty(value = "姓")
    private String firstName;


    @NotBlank(message = "名不能为空")
    @ApiModelProperty(value = "名")
    private String lastName;


    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;


    @Email
    @Null(message = "用户邮箱不可修改")
    @ApiModelProperty(value = "邮箱")
    private String email;


    @Null(message = "用户创建时间不可修改")
    @ApiModelProperty(value = "创建时间")
    private Date accountCreated;

    /**
     *
     */
    @Null(message = "用户更新时间不可修改")
    @ApiModelProperty(value = "更新时间")
    private Date accountUpdate;

}
