package com.hsy.parrot.shop.service;

import com.hsy.parrot.bean.fruits.Order;
import com.hsy.parrot.bean.response.GeneConstant;
import com.hsy.parrot.bean.response.ResponseEntity;
import com.hsy.parrot.constant.ParameterConstant;
import com.hsy.parrot.lock.RedisDistributedLock;
import com.hsy.parrot.lock.ZooKeeperSession;
import com.hsy.parrot.shop.dao.OrderDao;
import com.hsy.parrot.utils.CommonUtils;
import com.hsy.parrot.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author:hsy
 * @description:
 * @date 2020/3/9 11:02
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RedisDistributedLock distributedLock;

    @Autowired
    private ZooKeeperSession zooKeeperSession;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity addOrder(Order order) {
        final int VALVE = Integer.parseInt((String) RedisUtil.get(ParameterConstant.SHOP_SHORTAGE_KEY));
        final int TIME_OUT = Integer.parseInt((String) RedisUtil.get(ParameterConstant.DISTRIBUTION_LOCK_KEY_TIMEOUT_KEY));
        String redisStock = (String) RedisUtil.get(CommonUtils.createStockRedisKey(order.getFruitsCode()));
        String[] stockArray = redisStock.split(ParameterConstant.SYMBOL_UNDERLINE);
        if (Integer.valueOf(stockArray[0]) < Integer.valueOf(stockArray[1]) + Integer.valueOf(stockArray[2]) + order.getCount())
            return new ResponseEntity(GeneConstant.ERROR, "商品数量不足");

        String retIdentifier = null;
        if (Integer.valueOf(stockArray[0]) - Integer.valueOf(stockArray[1]) - Integer.valueOf(stockArray[2]) <= VALVE) {
            zooKeeperSession.acquireDistributedLock(order.getFruitsCode());

            // redis分布式锁
//            retIdentifier = distributedLock.lockWithTimeout(order.getFruitsCode(), TIME_OUT, null);
            String redisStock2 = (String) RedisUtil.get(CommonUtils.createStockRedisKey(order.getFruitsCode()));
            String[] stockArray2 = redisStock2.split(ParameterConstant.SYMBOL_UNDERLINE);
            if (Integer.valueOf(stockArray2[0]) < Integer.valueOf(stockArray2[1]) + Integer.valueOf(stockArray2[2]) + order.getCount())
                return new ResponseEntity(GeneConstant.ERROR, "商品数量不足");
//            if (retIdentifier == null) {
//                log.warn("添加锁失败");
//                throw new RuntimeException("添加锁失败！！！");
//            }
        }
        order.setOrderNumber(UUID.randomUUID().toString());
        orderDao.addOrder(order);
        orderDao.updateFruits(order);
        RedisUtil.set(CommonUtils.createStockRedisKey(order.getFruitsCode()), CommonUtils.createStockRedisValue(stockArray[0], String.valueOf(Integer.valueOf(stockArray[1]) + order.getCount()), stockArray[2]));
        zooKeeperSession.releaseDistributedLock(order.getFruitsCode());
//        if (retIdentifier != null)
//            distributedLock.releaseLock(order.getFruitsCode(), retIdentifier);
        return new ResponseEntity(GeneConstant.SUCCESS);
    }
}
