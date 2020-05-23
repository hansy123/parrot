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
     * 编号
     */
    private String code;

    /**
     * 单价
     */
    private Double price;

    /**
     * 总库存
     */
    private Integer count;

    /**
     * 锁定库存
     */
    private Integer lockCount;

    /**
     * 剩余库存
     */
    private Integer surplusCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
