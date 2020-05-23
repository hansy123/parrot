package com.hsy.parrot.bean.fruits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 10:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * ���
     */
    private String code;

    /**
     * ����
     */
    private Double price;

    /**
     * �ܿ��
     */
    private Integer count;

    /**
     * �������
     */
    private Integer lockCount;

    /**
     * ʣ����
     */
    private Integer surplusCount;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * ����ʱ��
     */
    private Date updateTime;
}
