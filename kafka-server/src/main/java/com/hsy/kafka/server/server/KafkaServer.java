package com.hsy.kafka.server.server;

import com.hsy.parrot.bean.kafka.KafkaInMsg;

public interface KafkaServer {
    void insertIfNotExist(KafkaInMsg inMsg);
}
