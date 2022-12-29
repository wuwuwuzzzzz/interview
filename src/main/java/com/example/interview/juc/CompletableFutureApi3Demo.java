package com.example.interview.juc;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author wxz
 * @date 15:45 2022/12/29
 */
public class CompletableFutureApi3Demo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("111");
            return 1;
        }).thenApply(f -> {
            System.out.println("222");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("333");
            return f + 3;
        }).thenAccept(System.out::println);
    }
}
