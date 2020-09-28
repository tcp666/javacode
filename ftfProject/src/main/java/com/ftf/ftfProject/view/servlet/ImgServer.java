package com.ftf.ftfProject.view.servlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@ResponseBody
public class ImgServer {
    @RequestMapping("/imgServer")
    public File img(){
        System.out.println("...............");
        File file=new File("D:\\SpringDemos\\ftfProject\\src\\main\\resources\\static\\images\\1.jpg");
        return file;
    }
}
