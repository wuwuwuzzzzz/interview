package com.example.interview.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 16:59 2022/12/29
 */
public class CompletableFutureFastDemo {
    public static void main(String[] args) {

        CompletableFuture<String> playA = CompletableFuture.supplyAsync(() -> {

            System.out.println("A come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "playA";
        });

        CompletableFuture<String> playB = CompletableFuture.supplyAsync(() -> {

            System.out.println("B come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "playB";
        });

        CompletableFuture<String> result = playA.applyToEither(playB, f -> {
            return f + " is win";
        });

        System.out.println(Thread.currentThread().getName() + "\t" + "-------" + result.join());
    }
}
