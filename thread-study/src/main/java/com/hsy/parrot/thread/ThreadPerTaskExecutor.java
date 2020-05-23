package com.hsy.parrot.thread;

import java.util.concurrent.Executor;

/**
 * @author:hsy
 * @description:
 * @date 2020/1/9 15:14
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
