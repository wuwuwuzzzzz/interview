package com.example.interview.juc;

import java.util.concurrent.Callable;

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}

/**
 *
 * @author wxz
 * @date 15:15 2022/12/26
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {

    }

}
