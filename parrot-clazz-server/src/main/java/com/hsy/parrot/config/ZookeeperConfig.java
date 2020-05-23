package com.hsy.parrot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;

@Configuration
@Slf4j
public class ZookeeperConfig {

    @Value("${zookeeper.address}")
    private String connectUrl;

    @Value("${zookeeper.timeout}")
    private int timeout;

    @Bean(name = "zkClient")
    public ZooKeeper zkClient() {
        ZooKeeper zooKeeper = null;
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            //���ӳɹ��󣬻�ص�watcher�����������Ӳ������첽�ģ�ִ����new����ֱ�ӵ��ú�������
            //  ��ָ����̨�����ַ 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
            zooKeeper = new ZooKeeper(connectUrl, timeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (Event.KeeperState.SyncConnected == event.getState()) {
                        //����յ��˷���˵���Ӧ�¼�,���ӳɹ�
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            log.info("����ʼ��ZooKeeper����״̬....��={}", zooKeeper.getState());

        } catch (Exception e) {
            log.error("��ʼ��ZooKeeper�����쳣....��={}", e);
        }
        return zooKeeper;
    }
}
