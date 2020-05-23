package com.hsy.parrot.websocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/16 18:16
 */
@RestController
public class SocketController {
    @Resource
    private WebSocketServer webSocketServer;

    /**
     * ��ָ���û�������Ϣ
     * @param userName �û���
     * @param message ��Ϣ
     * @throws IOException
     */
    @RequestMapping(value = "/socket", method = RequestMethod.GET)
    public void testSocket1(@RequestParam String userName, @RequestParam String message){
        webSocketServer.sendInfo(userName, message);
    }

    /**
     * �������û�������Ϣ
     * @param message ��Ϣ
     * @throws IOException
     */
    @RequestMapping(value = "/socket/all", method = RequestMethod.GET)
    public void testSocket2(@RequestParam String message){
        try {
            webSocketServer.onMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
