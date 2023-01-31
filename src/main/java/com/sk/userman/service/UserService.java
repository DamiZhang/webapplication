package com.sk.userman.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sk.userman.domain.User;
import com.sk.userman.dto.LoginDTO;
import com.sk.userman.dto.UserDTO;
import com.sk.userman.vo.UserVO;


/**
*
*/
public interface UserService extends IService<User> {

    void register(User user);

    String login(LoginDTO loginDTO);

    UserVO info();

    void updateInfo(UserDTO userDTO);
}
