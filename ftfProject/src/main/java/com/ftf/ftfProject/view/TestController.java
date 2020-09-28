package com.ftf.ftfProject.view;

import com.ftf.ftfProject.entity.*;
import com.ftf.ftfProject.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class TestController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CollectionsServiceImpl collectionsService;

    @Autowired
    private CommentsServiceImpl commentsService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private RelationServiceImpl relationService;

    @RequestMapping("/user")
//    List<Users>
    public List<Users>  getAllUsert(){
        System.out.println(userService.selectAll().toString()+"*********************");
        return userService.selectAll();
//   return "hello";
    }


    @RequestMapping("/collection")
    public List<Collections> getAllCollection(){
        return collectionsService.getCollections();
    }

    @RequestMapping("/comment")
    public List<Comments> getAllComment(){
        return commentsService.getAllComments();
    }

    @RequestMapping("/message")
    public List<Message> getAllMessage(){
        return messageService.getAllMessage();
    }

    @RequestMapping("/relation")
    public List<Relation> getAllRelation(){
        return relationService.getAllRelation();
    }

}
