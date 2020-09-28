package com.tcp.tcpchat.controller;

import com.tcp.tcpchat.entity.User;
import com.tcp.tcpchat.service.imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private UserServiceImpl userServiceImp;

    @RequestMapping("/login")
    public List<User> login(User user){
        return userServiceImp.findAll();
    }
}
