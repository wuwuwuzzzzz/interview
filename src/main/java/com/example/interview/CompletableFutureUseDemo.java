package com.example.interview;

import java.util.concurrent.*;

/**
 * @author wxz
 * @date 22:26 2022/12/28
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName());
                int i = ThreadLocalRandom.current().nextInt(10);
                try {

                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("1秒钟后出结果: " + i);

                if (i > 5) {
                    int j = 10/0;
                }

                return i;
            }, threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("计算完成: " + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况: " + e.getCause() + "\t" + e.getMessage());
                return null;
            });

            System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void future1() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            int i = ThreadLocalRandom.current().nextInt(10);
            try {

                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1秒钟后出结果: " + i);
            return i;
        });

        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");

        System.out.println(completableFuture.get());
    }
}
