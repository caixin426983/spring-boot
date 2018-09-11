package com.cx.springboot.config.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @Description 创建握手 此类用来获取登录用户信息并交由WebSocket管理
 * @Author cx
 * @Date 2018/9/11 10:48
 **/
public class WebSocketInterceptor implements HandshakeInterceptor {

    private Logger logger = LoggerFactory.getLogger(WebSocketInterceptor.class);


    /**
     * 在握手之前执行该方法，继续握手返回true，终端握手返回false，通过attributes参数设置WebSocketSession的属性
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {

        logger.info("xxx用户建立连接");
        if (request instanceof ServletServerHttpRequest) {
            String userId = ((ServletServerHttpRequest) request).getServletRequest().getParameter("userId");
            attributes.put("userId", userId);
            logger.info("用户唯一标识：" + userId);
        }
        return true;
    }


    /**
     * 在握手之后执行该方法，无论是否握手成功都指明了响应状态码和响应头
     */
    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
                               WebSocketHandler webSocketHandler, @Nullable Exception e) {

    }
}
