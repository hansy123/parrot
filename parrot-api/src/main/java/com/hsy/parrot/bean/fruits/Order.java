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
     * 订单编号
     */
    private String orderNumber;

    /**
     * 1待支付2已支付3已退款4完成
     */
    private Integer status;

    /**
     * 商品code
     */
    private String fruitsCode;

    /**
     * 订单金额
     */
    private Double price;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
