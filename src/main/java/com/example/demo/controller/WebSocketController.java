package com.example.demo.controller;

import com.example.demo.helpers.R;
import com.example.demo.service.WebSocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebSocketController {

    @Resource
    private WebSocket webSocket;

    /**
     * 单发
     */
    @GetMapping("/ws/{user_id}/{msg}")
    public R wsSend(@PathVariable String user_id, @PathVariable String msg) {
        if (webSocket.countClient() > 0) {
            webSocket.sendMessageToUser(msg, user_id);
            return R.success("发送成功");
        }
        return R.failed();
    }

    /**
     * 群发
     */
    @GetMapping("/ws/{msg}")
    public R wsSendMany(@PathVariable String msg) {
        if (webSocket.countClient() > 0) {
            webSocket.sendMessage(msg);
            return R.success("发送成功");
        }
        return R.failed();
    }
}
