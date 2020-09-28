package com.tcp.tcpchat.service;

import com.tcp.tcpchat.entity.User;


import java.util.List;


public interface UserService {

    List<User> findAll();
}
