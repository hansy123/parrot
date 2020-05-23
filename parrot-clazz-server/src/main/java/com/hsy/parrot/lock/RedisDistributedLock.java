package com.hsy.parrot.lock;

import com.hsy.parrot.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author:hsy
 * @description:分布式锁
 * @date 2019/12/25 17:44
 */
@Slf4j
@Component
public class RedisDistributedLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    public RedisDistributedLock(StringRedisTemplate stringRedisTemplate) {
//        this.stringRedisTemplate = stringRedisTemplate;
//    }

    /**
     * 获取锁
     *
     * @param lockName : 锁的名称
     * @param timeout: 获取锁超时时间，释放锁的超时时间,单位秒
     * @param lockValue: 锁的值，可为null
     * @return
     */
    public String lockWithTimeout(String lockName, long timeout, String lockValue) {

        String retIdentifier = null;
        try {
            String identifier = getLocakValue(timeout);// 生成锁过期时间，该时间为锁的值
            String lockKey = "lock:" + lockName;
            int lockExpire = (int) timeout;// 超时时间，上锁后超过此时间则自动释放锁,单位秒
            while (true) {
                if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey, identifier)) {// 不存在，则添加锁，即向redis中添加值
                    log.info("{}:获取到锁lockKey：{}", Thread.currentThread().getName(), lockKey);
                    stringRedisTemplate.expire(lockKey, lockExpire, TimeUnit.SECONDS);
                    retIdentifier = identifier;// 返回value值，用于释放锁时间确认
                    break;
                } else {// 锁已经存在,则考虑重入锁和死锁
                    Date oldLockValue = DateUtil.parse(stringRedisTemplate.opsForValue().get(lockKey), "yyyy-MM-dd HH:mm:ss");
                    if (null != lockValue && stringRedisTemplate.opsForValue().get(lockKey).equals(lockKey)) {// 重入锁
                        stringRedisTemplate.opsForValue().set(lockKey, identifier, lockExpire, TimeUnit.SECONDS);
                        retIdentifier = identifier;
                        break;
                    }
                    // 如果锁已经过了超时时间，但redis中仍有值，此时需要删除该值
                    if (DateUtil.dateDiff(oldLockValue, new Date()) > 0) {//此时锁已经失效
                        stringRedisTemplate.opsForValue().getAndSet(lockKey, identifier);
                        stringRedisTemplate.expire(lockKey, lockExpire, TimeUnit.SECONDS);
                        retIdentifier = identifier;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取锁异常:[{}]", e.getStackTrace()[0]);
        }
        return retIdentifier;
    }

    /**
     * 释放锁
     *
     * @param lockName
     * @param retIdentifier
     * @return
     */
    public boolean releaseLock(String lockName, String retIdentifier) {
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;
        try {
            while (true) {
                stringRedisTemplate.watch(lockKey);// 监视lock，准备开始事务
                if (retIdentifier.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                    log.info("{}:删除锁lockKey：{}", Thread.currentThread().getName(), lockKey);
                    stringRedisTemplate.delete(lockKey);
                    retFlag = true;
                }
                stringRedisTemplate.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("释放锁异常:[{}]", e.getStackTrace()[0]);
        }
        return retFlag;
    }

    /**
     * @param timeOut 单位秒
     * @return
     */
    private String getLocakValue(long timeOut) {
        Date now = new Date();
        Date date = DateUtil.addSconds(now, (int) timeOut);
        return DateUtil.getFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

}
