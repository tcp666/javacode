package itsource.websocket;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

@WebServlet("/chat")
@ServerEndpoint("/chat")
public class ChatServer extends HttpServlet {

    Session session=null;
    /**
     * 通报建立成功
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        System.out.println(session.getUserProperties());
        System.out.println("通道建立成功");

    }
    @OnMessage
    public void onMessage(String message) throws IOException {

    }
    @OnClose
    public void onClose(){
        System.out.println("连接已经关闭");
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
