package com.example.interview.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

class BankAccount {

    String bankName = "CCB";

    public volatile int money = 0;

    public synchronized void add() {
        money++;
    }

    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater =
        AtomicIntegerFieldUpdater.newUpdater(BankAccount.class, "money");

    /**
     * 不加synchronized，保证高性能原子性
     *
     * @author wxz
     * @date 14:55 2023/1/31
     */
    public void transMoney(BankAccount bankAccount) {
        fieldUpdater.getAndIncrement(bankAccount);
    }
}

/**
 * @author wxz
 * @date 14:46 2023/1/31
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 1000; j++) {
                        //account.add();
                        account.transMoney(account);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "\t" + account.money);
    }
}
