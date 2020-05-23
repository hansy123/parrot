package com.hsy.parrot.init;

import com.hsy.parrot.bean.fruits.Apple;
import com.hsy.parrot.bean.paramter.CoParameter;
import com.hsy.parrot.parameter.ParameterDao;
import com.hsy.parrot.shop.dao.OrderDao;
import com.hsy.parrot.utils.CommonUtils;
import com.hsy.parrot.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 13:53
 */
@Slf4j
@Component
public class ShopInit implements ApplicationRunner {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ParameterDao parameterDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("-----init apple begin -----");
        List<Apple> apples = orderDao.getApples();
        if (!apples.isEmpty()) {
            apples.stream().forEach(apple -> {
                RedisUtil.set(CommonUtils.createStockRedisKey(apple.getCode()), CommonUtils.createStockRedisValue(apple.getCount(), apple.getLockCount(), apple.getSurplusCount()));
                RedisUtil.set(apple.getCode(), apple.toString());
            });
        }
        log.info("-----init apple end, init parameter begin-----");

        List<CoParameter> parameters = parameterDao.getParameter();
        if (!parameters.isEmpty()) {
            parameters.stream().forEach(parameter -> {
                RedisUtil.set(parameter.getKey(),parameter.getValue());
            });
        }
        log.info("-----init parameter end-----");
    }
}
