package com.example.interview.juc.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class House {

    int saleCount;

    public synchronized void saleHouse() {
        ++saleCount;
    }
}

/**
 *
 * @author wxz
 * @date 21:18 2023/2/5
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {

        House house = new House();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                int size = new Random().nextInt(5);
                System.out.println(size);
                for (int j = 0; j < size; j++) {
                    house.saleHouse();
                }
            }, String.valueOf(i)).start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "\t" + house.saleCount);
    }
}
