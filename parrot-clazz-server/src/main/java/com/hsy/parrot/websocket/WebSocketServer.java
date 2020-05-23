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
     * ������Ϣ
     *
     * @param session �ͻ�����socket�����ĻỰ
     * @param message ��Ϣ
     * @throws IOException
     */
    public void sendMessage(Session session, String message) throws IOException {
        if (session != null)
            session.getBasicRemote().sendText(message);
    }

    /**
     * ���ӽ����ɹ�����
     *
     * @param session  �ͻ�����socket�����ĻỰ
     * @param userName �ͻ��˵�userName
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String userName) {
        sessionPools.put(userName, session);
        addOnlineCount();
        log.info(userName + "����webSocket����ǰ����Ϊ" + online);
        try {
            sendMessage(session, "��ӭ" + userName + "�������ӣ�");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ر�����ʱ����
     *
     * @param userName �ر����ӵĿͻ��˵�����
     */
    @OnClose
    public void onClose(@PathParam(value = "name") String userName) {
        sessionPools.remove(userName);
        subOnlineCount();
        log.info(userName + "�Ͽ�webSocket���ӣ���ǰ����Ϊ" + online);
    }

    /**
     * �յ��ͻ�����Ϣʱ������Ⱥ����
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
     * ��������ʱ��
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("��������");
        throwable.printStackTrace();
    }

    /**
     * ��ָ���û�������Ϣ
     *
     * @param userName �û���
     * @param message  ��Ϣ
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
