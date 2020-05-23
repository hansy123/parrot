package com.hsy.parrot.thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:hsy
 * @description:
 * @date 2020/1/9 15:08
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;

    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    static int f = 1;

    public static void main(String[] args) {

        while (f < 3) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    f++;
                    System.out.println(f);
                    if (f == 3) {
                        List<Runnable> runnables = exec.shutdownNow();
                        runnables.stream().forEach(r -> System.out.println(r));
//                        exec.shutdown();

                    }
                }
            };
            exec.execute(task);
        }
    }
}
