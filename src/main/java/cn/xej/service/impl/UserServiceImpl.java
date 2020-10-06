package cn.xej.service.impl;

import cn.xej.mapper.UserMapper;
import cn.xej.pojo.User;
import cn.xej.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        User user = userMapper.getUser(username);
        return user;
    }
}
