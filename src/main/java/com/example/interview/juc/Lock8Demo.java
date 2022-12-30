package com.example.interview.juc;

import java.util.concurrent.TimeUnit;

class Phone {

    public synchronized void sendEmail() {
        System.out.println("---------- sendEmail");
    }

    public synchronized void sendSms() {
        System.out.println("---------- sendSMS");
    }
}

/**
 *
 * @author wxz
 * @date 10:00 2022/12/30
 */
public class Lock8Demo {
    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            phone.sendSms();
        }, "B").start();
    }
}
