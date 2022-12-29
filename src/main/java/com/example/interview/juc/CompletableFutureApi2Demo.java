package com.example.interview.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 15:31 2022/12/29
 */
public class CompletableFutureApi2Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("111");
            return 1;
        }).thenApply(f -> {
            System.out.println("222");
            return f + 2;
        }).handle((f, e) -> {
            int i = 10/0;
            System.out.println("333" + e);
            return f + 3;
        }).whenComplete((v,e) -> {
            if (e == null) {
                System.out.println("计算结果: " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        System.out.println(completableFuture.get());
    }
}
