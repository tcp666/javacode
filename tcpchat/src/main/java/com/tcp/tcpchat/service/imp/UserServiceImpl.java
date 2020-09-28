package com.tcp.tcpchat.service.imp;

import com.tcp.tcpchat.entity.User;
import com.tcp.tcpchat.mapper.UserMapper;
import com.tcp.tcpchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
       return userMapper.findAllUsers();
    }
}
