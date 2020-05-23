package com.hsy.parrot.bean.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * pojo
 *
 * @author hsy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaInMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private long id;
    /**
     * 档案号
     */
    private long fwBh;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtUpdate;

    /**
     * 消息
     */
    private String message;

    /**
     * 1未消费，2已消费
     */
    private int status;

    /**
     * 消息发送是否成功，1成功，2未成功
     */
    private int sendSuccess;

}