package com.hsy.parrot.shop.service;

import com.hsy.parrot.bean.fruits.Order;
import com.hsy.parrot.bean.response.ResponseEntity;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 11:01
 */
public interface OrderService {
    ResponseEntity addOrder(Order order);
}
