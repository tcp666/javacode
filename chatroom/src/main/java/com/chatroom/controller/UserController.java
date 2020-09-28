package com.chatroom.controller;

import com.chatroom.entity.Container;
import com.chatroom.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/8 21:19
 */
@Controller
@Slf4j
public class UserController {

    @Resource
    SimpMessagingTemplate template;

    @PostMapping(value = "/login")
    public void login(Users users, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(users);
        Container.list.add(users);
        Container.userNameList.add(users.getUsername());
        request.getSession().setAttribute("uname",users.getUsername());
        System.out.println("---login---");
        response.sendRedirect("main.html");
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String info = request.getSession().getAttribute("uname").toString();
        return "{\"info\":\""+info+"\"}";
    }

    @RequestMapping("/userList")
    @ResponseBody
    public String userList(HttpServletRequest request){
        String allUser="";
        for (String s : Container.userNameList) {
            allUser+=s+",";
        }
        allUser =   allUser.substring(0,allUser.length()-1);

        template.convertAndSend("/topic/userList",allUser);
        return "success";
    }

    @RequestMapping("/chat")
    @ResponseBody
    public String chat(String message,String username,HttpServletRequest request){

        String uname = (String) request.getSession().getAttribute("uname");
        message = message+","+uname;
        System.out.println("-------------------"+message+"---"+username+"--------------"+uname);
        template.convertAndSendToUser(username,"chat",message);
        return  "success";
    }

    @RequestMapping("/chattogroup")
    @ResponseBody
    public String chatToGroup(String message,String username,HttpServletRequest request){

        String uname = (String) request.getSession().getAttribute("uname");
        message = message+","+uname;
        System.out.println("-------------------"+message+"---"+username+"--------------"+uname);
        template.convertAndSend("/group/"+username,message);
        return  "success";
    }
}
