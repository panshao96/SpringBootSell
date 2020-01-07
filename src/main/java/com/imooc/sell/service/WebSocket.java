package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint("/webSocket")
public class WebSocket {

    private Session session;

    //WebSocket容器
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info(" 【websocket消息】 新的连接， 总数：{}", webSocketSet.size());
    }

    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this);
        log.info(" 【websocket消息】 连接断开， 总数：{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String msg) {
        log.info(" 【websocket消息】 收到消息：{}", msg);
    }

    public void sendMessage(String msg) {
        for (WebSocket webSocket: webSocketSet) {
            log.info(" 【websocket消息】 广播消息，message={}", msg);
            try {
                webSocket.session.getBasicRemote().sendText(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
