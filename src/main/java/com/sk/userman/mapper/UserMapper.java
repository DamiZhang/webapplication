package com.sk.userman.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sk.userman.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @Entity com.sk.userman.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
