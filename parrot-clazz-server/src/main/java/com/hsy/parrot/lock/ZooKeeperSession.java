package com.hsy.parrot.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class ZooKeeperSession {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    @Resource(name = "zkClient")
    private ZooKeeper zookeeper;

//    public ZooKeeperSession() {
//        // 去连接zookeeper server，创建会话的时候，是异步去进行的
//        // 所以要给一个监听器，说告诉我们什么时候才是真正完成了跟zk server的连接
//        try {
//            this.zookeeper = new ZooKeeper(
//                    "127.0.0.1:2181",
//                    50000,
//                    new ZooKeeperWatcher());
//            // 给一个状态CONNECTING，连接中
//            log.info("" + zookeeper.getState());
//
//            try {
//                // CountDownLatch
//                // java多线程并发同步的一个工具类
//                // 会传递进去一些数字，比如说1,2 ，3 都可以
//                // 然后await()，如果数字不是0，那么久卡住，等待
//
//                // 其他的线程可以调用coutnDown()，减1
//                // 如果数字减到0，那么之前所有在await的线程，都会逃出阻塞的状态
//                // 继续向下运行
//
//                connectedSemaphore.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            log.info("ZooKeeper session established......");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 获取分布式锁
     *
     * @param code
     */
    public void acquireDistributedLock(String code) {
        String path = "/product-lock-" + code;

        try {
            zookeeper.create(path, "".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            log.info("success to acquire lock for product[id=" + code + "]");
        } catch (Exception e) {
            // 如果那个商品对应的锁的node，已经存在了，就是已经被别人加锁了，那么就这里就会报错
            // NodeExistsException
            int count = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    zookeeper.create(path, "".getBytes(),
                            ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                } catch (Exception e2) {
                    count++;
                    log.info("the " + count + " times try to acquire lock for product[id=" + code + "]......");
                    continue;
                }
                log.info("success to acquire lock for product[id=" + code + "] after " + count + " times try......");
                break;
            }
        }
    }

    /**
     * 释放掉一个分布式锁
     *
     * @param code
     */
    public void releaseDistributedLock(String code) {
        String path = "/product-lock-" + code;
        try {
            zookeeper.delete(path, -1);
            log.info("release the lock for product[id=" + code + "]......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立zk session的watcher
     *
     * @author Administrator
     */
    private class ZooKeeperWatcher implements Watcher {

        public void process(WatchedEvent event) {
            log.info("Receive watched event: " + event.getState());
            if (Event.KeeperState.SyncConnected == event.getState()) {
                connectedSemaphore.countDown();
            }
        }

    }

    /**
     * 封装单例的静态内部类
     *
     * @author Administrator
     */
    private static class Singleton {

        private static ZooKeeperSession instance;

        static {
            instance = new ZooKeeperSession();
        }

        public static ZooKeeperSession getInstance() {
            return instance;
        }

    }

    /**
     * 获取单例
     *
     * @return
     */
    public static ZooKeeperSession getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 初始化单例的便捷方法
     */
    public static void init() {
        getInstance();
    }
}
