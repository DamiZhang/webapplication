package com.sk.userman.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    @TableId
    private Integer id;

    /**
     * 密码
     */

    private String password;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    /**
     * 创建时间
     */
    private Date accountCreated;

    /**
     * 更新时间
     */
    private Date accountUpdate;


}