package com.hsy.parrot.bean.fruits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 10:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * �������
     */
    private String orderNumber;

    /**
     * 1��֧��2��֧��3���˿�4���
     */
    private Integer status;

    /**
     * ��Ʒcode
     */
    private String fruitsCode;

    /**
     * �������
     */
    private Double price;

    /**
     * ��Ʒ����
     */
    private Integer count;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * ����ʱ��
     */
    private Date updateTime;

}
