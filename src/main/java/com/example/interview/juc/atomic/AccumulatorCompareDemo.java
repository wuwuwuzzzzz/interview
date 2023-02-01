package com.example.interview.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

class ClickNumber {

    int number = 0;

    public synchronized void clickBySynchronized() {
        number++;
    }

    AtomicLong atomicLong = new AtomicLong(0);

    public void clickByAtomicLong() {
        atomicLong.getAndIncrement();
    }

    LongAdder longAdder = new LongAdder();

    public void clickByLongAdder() {
        longAdder.increment();
    }

    LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

    public void clickByLongAccumulator() {
        longAccumulator.accumulate(1);
    }
}

/**
 *
 * @author wxz
 * @date 11:28 2023/2/1
 */
public class AccumulatorCompareDemo {

    public static final int _1W = 10000;

    public static final int threadNumber = 50;

    public static void main(String[] args) {

        ClickNumber clickNumber = new ClickNumber();
        long startTime;
        long endTime;

        CountDownLatch countDownLatch1 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch2 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch3 = new CountDownLatch(threadNumber);
        CountDownLatch countDownLatch4 = new CountDownLatch(threadNumber);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100 * _1W; j++) {
                        clickNumber.clickBySynchronized();
                    }
                } finally {
                    countDownLatch1.countDown();
                }
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch1.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "\t" + clickNumber.number);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100 * _1W; j++) {
                        clickNumber.clickByAtomicLong();
                    }
                } finally {
                    countDownLatch2.countDown();
                }
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch2.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "\t" + clickNumber.atomicLong.get());

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100 * _1W; j++) {
                        clickNumber.clickByLongAdder();
                    }
                } finally {
                    countDownLatch3.countDown();
                }
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch3.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "\t" + clickNumber.longAdder.sum());

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100 * _1W; j++) {
                        clickNumber.clickByLongAccumulator();
                    }
                } finally {
                    countDownLatch4.countDown();
                }
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch4.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "\t" + clickNumber.longAccumulator.get());
    }
}
