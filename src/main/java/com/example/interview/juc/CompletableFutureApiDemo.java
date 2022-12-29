package com.example.interview.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author wxz
 * @date 15:17 2022/12/29
 */
public class CompletableFutureApiDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "abc";
        });

        System.out.println(completableFuture.get());
        System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));
        System.out.println(completableFuture.join());
        System.out.println(completableFuture.getNow("wxz"));
        System.out.println(completableFuture.complete("wxz") + "\t" + completableFuture.join());
    }
}
