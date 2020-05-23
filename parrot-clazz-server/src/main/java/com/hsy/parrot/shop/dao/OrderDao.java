package com.hsy.parrot.shop.dao;

import com.hsy.parrot.bean.fruits.Apple;
import com.hsy.parrot.bean.fruits.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 11:02
 */
@Mapper
@Repository
public interface OrderDao {

    void addOrder(@Param("der") Order order);

    void updateFruits(@Param("der") Order order);

    Apple getFruits(@Param("fruitsCode")String fruitsCode);

    List<Apple> getApples();
}
