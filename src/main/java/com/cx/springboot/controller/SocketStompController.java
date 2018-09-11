package com.cx.springboot.controller;

import com.cx.springboot.common.entity.ClientMessage;
import com.cx.springboot.common.entity.ServerMessage;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author cx
 * @Date 2018/9/11 14:52
 **/

@Controller
@Api(value = "socketStompController")
public class SocketStompController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //spring 提供的发送消息模板
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    private SimpUserRegistry userRegistry;

    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public ServerMessage sendDemo(ClientMessage message) {
        logger.info("接收到了信息" + message.getName());
        return new ServerMessage("你发送的消息为:" + message.getName());
    }


    @GetMapping("sendMessage")
    @ResponseBody
    public void sendMessage() {
        simpMessagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推送的数据"));
    }

    @RequestMapping(value = "/templateTest",method = RequestMethod.GET)
    @ResponseBody
    public void templateTest() {
        logger.info("当前在线人数：" + userRegistry.getUserCount());
        int i = 1;
        for (SimpUser user : userRegistry.getUsers()) {
            logger.info("用户" + i++ + "-------" + user);
        }
        //发送消息给指定用户
        simpMessagingTemplate.convertAndSendToUser("test", "/queue/message", new ServerMessage("服务器主动推的数据"));
    }

}
