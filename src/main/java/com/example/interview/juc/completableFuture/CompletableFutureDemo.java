package com.example.interview.juc.completableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("come in");
        return "wxz";
    }
}

/**
 * 为什么要使用future
 *
 * @author wxz
 * @date 15:15 2022/12/26
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        System.out.println(futureTask.get());
    }

}
