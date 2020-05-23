package com.hsy.kafka.server.mapper;

import com.hsy.parrot.bean.kafka.KafkaInMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface KafkaMapper {

    @Insert("INSERT IGNORE INTO xy_kafka_in_msg(fw_bh,gmt_update,message) VALUES(#{inMsg.fwBh},#{inMsg.gmtUpdate},#{inMsg.message}) ")
    int insertIfNotExist(@Param("inMsg") KafkaInMsg inMsg);

    void updateMessageStatus(@Param("content") String content);

    void recodeConsumer(@Param("content") String content);
}
