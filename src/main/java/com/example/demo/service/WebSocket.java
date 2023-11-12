package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/ws")
@Slf4j
public class WebSocket {

    protected Session session;

    private static final CopyOnWriteArraySet<WebSocket> WebSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        WebSocketSet.add(this);
        log.info("有连接进来了{}", session.getBasicRemote());
    }

    @OnClose
    public void onClose(Session session) {
        this.session = session;
        WebSocketSet.remove(this);
        log.info("有连接断开了{}", session.getId());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("收到消息{}", message);
    }

    /**
     * 群发
     */
    public void sendMessage(String message) {
        for (WebSocket webSocket : WebSocketSet) {
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                log.error("发生错误{}", e.getMessage());
            }
        }
    }


    /**
     * 单发
     */
    public void sendMessageToUser(String message, String userID) {
        for (WebSocket webSocket : WebSocketSet) {
            if (Objects.equals(webSocket.session.getId(), userID)) {
                try {
                    webSocket.session.getBasicRemote().sendText(message);
                } catch (Exception e) {
                    log.error("发生错误{}", e.getMessage());
                }
            }
        }
    }

    /**
     * 计算有多少个链接
     */
    public int countClient() {
        return WebSocketSet.size();
    }

}
