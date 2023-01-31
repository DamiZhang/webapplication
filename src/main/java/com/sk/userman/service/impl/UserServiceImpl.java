package com.sk.userman.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sk.userman.domain.User;
import com.sk.userman.dto.LoginDTO;
import com.sk.userman.dto.UserDTO;
import com.sk.userman.exception.BusinessException;
import com.sk.userman.mapper.UserMapper;
import com.sk.userman.service.UserService;
import com.sk.userman.utils.BaseContext;
import com.sk.userman.utils.JwtUtils;
import com.sk.userman.utils.BCryptUtils;
import com.sk.userman.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
*
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{


    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void register(User user) {

        User oneUser = getOne(new QueryWrapper<User>().eq("email", user.getEmail()));
        if (oneUser == null) {
            //进行加密
            user.setPassword(BCryptUtils.encode(user.getPassword()));
            user.setAccountCreated(new Date());
            user.setAccountUpdate(new Date());
            save(user);
        }else {
            throw new BusinessException("邮箱已被注册");
        }
    }

    @Override
    public String login(LoginDTO loginDTO) {

        User user = getOne(new QueryWrapper<User>().eq("email", loginDTO.getEmail()));


        if (user == null ){
            throw new BusinessException("用户不存在");
        }

        if (BCryptUtils.matches(loginDTO.getPassword(),user.getPassword())){
            return jwtUtils.generateToken(user.getId());
        }
        throw new BusinessException("用户名或密码错误");
    }

    @Override
    public UserVO info() {

        User user = getById(BaseContext.get());
        if (user == null) {
            throw new BusinessException("获取信息失败,请先登录");
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;

    }

    @Override
    public void updateInfo(UserDTO userDTO) {
        String userId = BaseContext.get();
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setPassword(BCryptUtils.encode(userDTO.getPassword()));
        user.setId(Integer.parseInt(userId));
        user.setAccountUpdate(new Date());
        updateById(user);
    }
}
