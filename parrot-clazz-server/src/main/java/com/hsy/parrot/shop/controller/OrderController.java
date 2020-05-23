package com.hsy.parrot.shop.controller;

import com.hsy.parrot.bean.fruits.Order;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 11:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/addOrder")
    public ResponseEntity addOrder(@RequestBody Order order){
        log.info("enter addOrder method");
        ResponseEntity result;
        try {
            result = orderService.addOrder(order);
        } catch (Exception e) {
            result = new ResponseEntity(GeneConstant.ERROR);
            log.error("addOrder method fail,exception is {}", e);
        }
        log.info("addOrder method end");
        return result;
    }

}
