package com.example.interview.juc;

import java.util.concurrent.*;

/**
 *
 * @author wxz
 * @date 21:36 2022/12/26
 */
public class FutureThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return "task1 over";
        });
        executorService.submit(futureTask1);
        System.out.println(futureTask1.get());

        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "task2 over";
        });
        executorService.submit(futureTask2);
        System.out.println(futureTask2.get());

        TimeUnit.MILLISECONDS.sleep(300);

        long endTime = System.currentTimeMillis();
        System.out.println("costTime: " + (endTime - startTime) + " 毫秒");

        executorService.shutdown();
        System.out.println(Thread.currentThread().getName() + "\t ---------end");
    }

    private static void m1() throws InterruptedException {

        long startTime = System.currentTimeMillis();

        TimeUnit.MILLISECONDS.sleep(500);
        TimeUnit.MILLISECONDS.sleep(500);
        TimeUnit.MILLISECONDS.sleep(500);

        long endTime = System.currentTimeMillis();
        System.out.println("costTime: " + (endTime - startTime) + " 毫秒");
        System.out.println(Thread.currentThread().getName() + "\t ---------end");
    }
}
