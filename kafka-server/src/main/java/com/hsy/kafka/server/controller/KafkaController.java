package com.hsy.kafka.server.controller;

import com.alibaba.druid.util.StringUtils;
import com.hsy.kafka.server.server.KafkaServer;
import com.hsy.parrot.bean.kafka.KafkaInMsg;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/26 17:01
 */
@RestController
@RequestMapping(value = "/kafka", produces = "application/json")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaServer kafkaServer;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/sendMessage")
    public ResponseEntity sendMessage(@RequestParam("message") String message, @RequestParam("topic") String topic) {

        log.info("enter sendMessage, message is {},topic is {}", message, topic);
        if (StringUtils.isEmpty(message) || StringUtils.isEmpty(topic)) {
            log.error("消息或者队列名为空");
            return new ResponseEntity(GeneConstant.ERROR, "消息或者队列名为空");
        }
        ResponseEntity result;
        try {
            ListenableFuture listenableFuture = kafkaTemplate.send(topic, message);
            KafkaInMsg inMsg = new KafkaInMsg();
            inMsg.setMessage(message);
            inMsg.setFwBh(System.currentTimeMillis());
            listenableFuture.addCallback(
                    o -> inMsg.setStatus(1),
                    throwable -> inMsg.setStatus(1)
            );
            // 保存数据库
            kafkaServer.insertIfNotExist(inMsg);
            result = new ResponseEntity(GeneConstant.SUCCESS);
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("sendMessage method fail,exception is {}", e);
        }
        return result;
    }
}
