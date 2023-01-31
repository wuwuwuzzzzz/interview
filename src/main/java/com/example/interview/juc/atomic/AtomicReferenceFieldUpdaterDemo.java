package com.example.interview.juc.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

class MyVar {
    public volatile Boolean isInit = Boolean.FALSE;

    AtomicReferenceFieldUpdater<MyVar, Boolean> refFieldUpdater =
        AtomicReferenceFieldUpdater.newUpdater(MyVar.class, Boolean.class, "isInit");

    public void init(MyVar myVar) {

        if (refFieldUpdater.compareAndSet(myVar, Boolean.FALSE, Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName() + "\t" + "start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "end");
        } else {
            System.out.println(Thread.currentThread().getName() + "\t" + "已经有线程在初始化工作...");
        }
    }
}

/**
 * @author wxz
 * @date 14:46 2023/1/31
 */
public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {

        MyVar myVar = new MyVar();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myVar.init(myVar);
            }, String.valueOf( i)).start();
        }
    }
}
