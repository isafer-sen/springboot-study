package com.example.demo.controller;

import com.example.demo.service.WebSocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebSocketController {

    @Resource
    private WebSocket webSocket;

    @GetMapping("/ws/{user_id}/{msg}")
    public void wsSend(@PathVariable String user_id, @PathVariable String msg) {
        webSocket.sendMessageToUser(msg, user_id);
    }
}
