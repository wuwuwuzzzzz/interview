package com.example.interview.juc.volatiles;

import java.util.concurrent.TimeUnit;

class MyNumber {

    int number;

    public synchronized void addPlusPlus() {
        number++;
    }
}

/**
 *
 * @author wxz
 * @date 09:47 2023/1/9
 */
public class VolatileNoAtomicDemo {
    public static void main(String[] args) {

        MyNumber myNumber = new MyNumber();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1001; j++) {
                    myNumber.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myNumber.number);
    }
}
