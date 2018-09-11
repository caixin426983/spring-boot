package com.cx.springboot.common.entity;

/**
 * @Description 服务端发送消息实体
 * @Author cx
 * @Date 2018/9/11 14:23
 **/
public class ServerMessage {

    private String responseMessage;

    public ServerMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
