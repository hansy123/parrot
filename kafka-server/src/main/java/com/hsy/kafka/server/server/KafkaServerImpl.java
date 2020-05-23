package com.hsy.kafka.server.server;

import com.hsy.kafka.server.mapper.KafkaMapper;
import com.hsy.parrot.bean.kafka.KafkaInMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/26 17:02
 */
@Service
public class KafkaServerImpl implements KafkaServer {

    @Autowired
    private KafkaMapper kafkaMapper;

    @Override
    public void insertIfNotExist(KafkaInMsg inMsg) {
        kafkaMapper.insertIfNotExist(inMsg);
    }
}
