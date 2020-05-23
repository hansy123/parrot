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
 * @description:�ֲ�ʽ��
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
     * ��ȡ��
     *
     * @param lockName : ��������
     * @param timeout: ��ȡ����ʱʱ�䣬�ͷ����ĳ�ʱʱ��,��λ��
     * @param lockValue: ����ֵ����Ϊnull
     * @return
     */
    public String lockWithTimeout(String lockName, long timeout, String lockValue) {

        String retIdentifier = null;
        try {
            String identifier = getLocakValue(timeout);// ����������ʱ�䣬��ʱ��Ϊ����ֵ
            String lockKey = "lock:" + lockName;
            int lockExpire = (int) timeout;// ��ʱʱ�䣬�����󳬹���ʱ�����Զ��ͷ���,��λ��
            while (true) {
                if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey, identifier)) {// �����ڣ��������������redis�����ֵ
                    log.info("{}:��ȡ����lockKey��{}", Thread.currentThread().getName(), lockKey);
                    stringRedisTemplate.expire(lockKey, lockExpire, TimeUnit.SECONDS);
                    retIdentifier = identifier;// ����valueֵ�������ͷ���ʱ��ȷ��
                    break;
                } else {// ���Ѿ�����,����������������
                    Date oldLockValue = DateUtil.parse(stringRedisTemplate.opsForValue().get(lockKey), "yyyy-MM-dd HH:mm:ss");
                    if (null != lockValue && stringRedisTemplate.opsForValue().get(lockKey).equals(lockKey)) {// ������
                        stringRedisTemplate.opsForValue().set(lockKey, identifier, lockExpire, TimeUnit.SECONDS);
                        retIdentifier = identifier;
                        break;
                    }
                    // ������Ѿ����˳�ʱʱ�䣬��redis������ֵ����ʱ��Ҫɾ����ֵ
                    if (DateUtil.dateDiff(oldLockValue, new Date()) > 0) {//��ʱ���Ѿ�ʧЧ
                        stringRedisTemplate.opsForValue().getAndSet(lockKey, identifier);
                        stringRedisTemplate.expire(lockKey, lockExpire, TimeUnit.SECONDS);
                        retIdentifier = identifier;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("��ȡ���쳣:[{}]", e.getStackTrace()[0]);
        }
        return retIdentifier;
    }

    /**
     * �ͷ���
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
                stringRedisTemplate.watch(lockKey);// ����lock��׼����ʼ����
                if (retIdentifier.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                    log.info("{}:ɾ����lockKey��{}", Thread.currentThread().getName(), lockKey);
                    stringRedisTemplate.delete(lockKey);
                    retFlag = true;
                }
                stringRedisTemplate.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("�ͷ����쳣:[{}]", e.getStackTrace()[0]);
        }
        return retFlag;
    }

    /**
     * @param timeOut ��λ��
     * @return
     */
    private String getLocakValue(long timeOut) {
        Date now = new Date();
        Date date = DateUtil.addSconds(now, (int) timeOut);
        return DateUtil.getFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

}
