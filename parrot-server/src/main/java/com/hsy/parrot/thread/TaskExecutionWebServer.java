package com.hsy.parrot.thread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:hsy
 * @description:
 * @date 2019/12/23 11:59
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        System.out.println("begin");
        while (!exec.isShutdown()) {
            try {
                Thread t = new Thread(() -> System.out.println("Thread:" + Thread.currentThread().getName()));
                exec.execute(t);
            } catch (Exception e) {
                if (!exec.isShutdown())
                    System.out.println("task submission rejected" + e);
            }
        }
        System.out.println("end");
    }


}
