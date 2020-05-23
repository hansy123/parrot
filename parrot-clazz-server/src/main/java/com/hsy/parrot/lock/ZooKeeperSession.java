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
//        // ȥ����zookeeper server�������Ự��ʱ�����첽ȥ���е�
//        // ����Ҫ��һ����������˵��������ʲôʱ�������������˸�zk server������
//        try {
//            this.zookeeper = new ZooKeeper(
//                    "127.0.0.1:2181",
//                    50000,
//                    new ZooKeeperWatcher());
//            // ��һ��״̬CONNECTING��������
//            log.info("" + zookeeper.getState());
//
//            try {
//                // CountDownLatch
//                // java���̲߳���ͬ����һ��������
//                // �ᴫ�ݽ�ȥһЩ���֣�����˵1,2 ��3 ������
//                // Ȼ��await()��������ֲ���0����ô�ÿ�ס���ȴ�
//
//                // �������߳̿��Ե���coutnDown()����1
//                // ������ּ���0����ô֮ǰ������await���̣߳������ӳ�������״̬
//                // ������������
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
     * ��ȡ�ֲ�ʽ��
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
            // ����Ǹ���Ʒ��Ӧ������node���Ѿ������ˣ������Ѿ������˼����ˣ���ô������ͻᱨ��
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
     * �ͷŵ�һ���ֲ�ʽ��
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
     * ����zk session��watcher
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
     * ��װ�����ľ�̬�ڲ���
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
     * ��ȡ����
     *
     * @return
     */
    public static ZooKeeperSession getInstance() {
        return Singleton.getInstance();
    }

    /**
     * ��ʼ�������ı�ݷ���
     */
    public static void init() {
        getInstance();
    }
}
