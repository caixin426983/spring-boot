package com.cx.springboot.controller;

import com.cx.springboot.config.socket.WebSocketPushHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * @Description TODO
 * @Author cx
 * @Date 2018/9/11 14:05
 **/

@RestController
@RequestMapping(value = "socket")
@Api(value = "socketController")
public class SocketController {



    @ApiOperation(value = "发送消息")
    @RequestMapping(value = "/senMessage", method = RequestMethod.GET)
    public void senMessage() {
        WebSocketPushHandler socketPushHandler = new WebSocketPushHandler();
        TextMessage message = new TextMessage("测试消息");
        socketPushHandler.sendMessageToUser("2256", message);
    }




}
