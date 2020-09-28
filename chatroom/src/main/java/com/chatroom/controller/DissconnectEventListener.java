package com.chatroom.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @Description TODO
 * @Author gyhdx
 * @Date 2020/4/9 11:36
 */
@Component
public class DissconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

    /**
     * 在事件触发的时候调用这个方法
     *
     * StompHeaderAccessor  简单消息传递协议中处理消息头的基类，
     * 通过这个类，可以获取消息类型(例如:发布订阅，建立连接断开连接)，会话id等
     *
     */
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor headerAccessor =  StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        System.out.println("【SubscribeEventListener监听器事件 类型】"+headerAccessor.getCommand().getMessageType());
        System.out.println("【SubscribeEventListener监听器事件 sessionId】"+headerAccessor.getSessionAttributes());
        System.out.println(headerAccessor);
        System.out.println(sessionDisconnectEvent);
    }
}

