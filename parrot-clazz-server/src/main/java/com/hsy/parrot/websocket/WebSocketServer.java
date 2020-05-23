package com.hsy.parrot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/16 17:58
 */
@Component
@ServerEndpoint(value = "/socket/{name}")
@Slf4j
public class WebSocketServer {

    private static AtomicInteger online = new AtomicInteger();

    private static Map<String, Session> sessionPools = new HashMap<>();

    /**
     * 发送消息
     *
     * @param session 客户端与socket建立的会话
     * @param message 消息
     * @throws IOException
     */
    public void sendMessage(Session session, String message) throws IOException {
        if (session != null)
            session.getBasicRemote().sendText(message);
    }

    /**
     * 连接建立成功调用
     *
     * @param session  客户端与socket建立的会话
     * @param userName 客户端的userName
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String userName) {
        sessionPools.put(userName, session);
        addOnlineCount();
        log.info(userName + "加入webSocket！当前人数为" + online);
        try {
            sendMessage(session, "欢迎" + userName + "加入连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接时调用
     *
     * @param userName 关闭连接的客户端的姓名
     */
    @OnClose
    public void onClose(@PathParam(value = "name") String userName) {
        sessionPools.remove(userName);
        subOnlineCount();
        log.info(userName + "断开webSocket连接！当前人数为" + online);
    }

    /**
     * 收到客户端消息时触发（群发）
     *
     * @param message
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        for (Session session : sessionPools.values()) {
            try {
                sendMessage(session, message);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时候
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("发生错误");
        throwable.printStackTrace();
    }

    /**
     * 给指定用户发送消息
     *
     * @param userName 用户名
     * @param message  消息
     * @throws IOException
     */
    public void sendInfo(String userName, String message) {
        Session session = sessionPools.get(userName);
        try {
            sendMessage(session, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void subOnlineCount() {
        online.decrementAndGet();
    }

    private void addOnlineCount() {
        online.incrementAndGet();
    }
}
