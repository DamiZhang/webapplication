package com.sk.userman.controller;

import com.sk.userman.domain.User;
import com.sk.userman.dto.LoginDTO;
import com.sk.userman.dto.UserDTO;
import com.sk.userman.service.UserService;
import com.sk.userman.utils.Result;
import com.sk.userman.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**

 **/
@RequestMapping("userman")
@RestController
@Api(tags="用户管理")
public class UserController {

    /**
     *
     * controller  -> service -> dao/mapper
     *
     */


    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody LoginDTO loginDTO){
        String token = userService.login(loginDTO);
        Result<String> stringResult = new Result<>();
        stringResult.setResult(token);
        return stringResult;
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result register(@Validated @RequestBody User user){
        userService.register(user);
        return new Result<>().ok("注册成功");
    }

    @ApiOperation(value = "获取当前用户信息",response = UserVO.class)
    @ApiImplicitParam(value = "鉴权token",name = "token",paramType  = "header", dataType = "String", required=true)
    @GetMapping("/info")
    public Result info(){
        UserVO info = userService.info();
        return new Result<>().ok(info);
    }

    @ApiOperation("修改当前用户信息")
    @ApiImplicitParam(value = "鉴权token",name = "token",paramType  = "header", dataType = "String", required=true)
    @PutMapping("/info")
    public Result updateInfo(@Validated @RequestBody UserDTO userDTO){
        userService.updateInfo(userDTO);
        return new Result<>().ok("更新成功");
    }

}
