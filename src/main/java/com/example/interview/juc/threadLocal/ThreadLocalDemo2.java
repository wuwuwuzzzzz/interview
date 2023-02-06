package com.example.interview.juc.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyData {

    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public  void add() {
        threadLocal.set(1 + threadLocal.get());
    }
}

/**
 *
 * @author wxz
 * @date 09:32 2023/2/6
 */
public class ThreadLocalDemo2 {
    public static void main(String[] args) {

        MyData myData = new MyData();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> {
                    Integer beforeInt = myData.threadLocal.get();
                    myData.add();
                    Integer afterInt = myData.threadLocal.get();
                    System.out.println(Thread.currentThread().getName() + "\t" + beforeInt + "\t" + afterInt);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdownNow();
        }
    }
}
