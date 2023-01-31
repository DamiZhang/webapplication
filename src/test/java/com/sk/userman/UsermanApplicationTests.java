package com.sk.userman;


import com.sk.userman.domain.User;
import com.sk.userman.dto.LoginDTO;
import com.sk.userman.dto.UserDTO;
import com.sk.userman.service.UserService;
import com.sk.userman.utils.BaseContext;
import com.sk.userman.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class UsermanApplicationTests {

    @Autowired
    private UserService userService;

    /**
     * 测试注册
     */
    @Test
    public void register(){
        User user = new User();
        user.setPassword("123456");
        user.setEmail("28333@qq.com");
        user.setFirstName("小");
        user.setLastName("hou");
        userService.register(user);
    }


    /**
     * 测试登录
     */
    @Test
    public void login(){
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("28333@qq.com");
        loginDTO.setPassword("123456");
        String token = userService.login(loginDTO);

        System.out.println(token);
    }


    /**
     * 测试获取信息
     */
    @Test
    public void getUserInfo(){
        BaseContext.set("11");
        UserVO info = userService.info();

        System.out.println(info);
    }


    /**
     * 测试修改信息
     */
    @Test
    public void updateUserInfo(){
        BaseContext.set("11");
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("28333@qq.com");
        userDTO.setPassword("123456");
        userService.updateInfo(userDTO);
    }

}
