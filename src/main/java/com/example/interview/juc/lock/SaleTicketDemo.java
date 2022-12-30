package com.example.interview.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

class Ticket {

    private int number = 50;

    ReentrantLock lock = new ReentrantLock(true);

    public void sale() {
        lock.lock();
        try {
           if (number > 0) {
               System.out.println(Thread.currentThread().getName() + "卖出第: \t" + (number--) + "\t 还剩下: " + number);
           }
        } finally {
          lock.unlock();
        }

    }
}

/**
 *
 * @author wxz
 * @date 11:55 2022/12/30
 */
public class SaleTicketDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}
