package com.example.interview.juc.lockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxz
 * @date 14:30 2023/1/3
 */
public class LockSupport2Demo {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t -------- come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t -------- 被唤醒");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            lock.lock();
            try {
              condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t -------- 发出通知");
            } finally {
              lock.unlock();
            }

        }, "t2").start();
    }
}
