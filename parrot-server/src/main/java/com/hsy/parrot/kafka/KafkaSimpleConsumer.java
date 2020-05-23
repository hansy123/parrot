//package com.hsy.parrot.kafka;
//
//import com.hsy.parrot.clazz.service.ClazzService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Component;
//
///**
// * @author:hsy
// * @description:
// * @date 2019/12/19 10:19
// */
//@Slf4j
//@Component
//public class KafkaSimpleConsumer {
//
//    @Autowired
//    private ClazzService kafkaServer;
//
//    // ��������
////    @KafkaListener(groupId = "simpleGroup", topics = "simple")
//    public void consumer1_1(ConsumerRecord<String, Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer, Acknowledgment ack) {
//        log.info("����������������Ϣ,topic= {} ,content = {}", topic, record.value());
//        log.info("consumer content = {}", consumer);
//        ack.acknowledge();
//        // ����parrot-clazz-server �ظ���Ϣ��������ݿ�
//        kafkaServer.updateStatus((String) record.value());
//    }
//}
