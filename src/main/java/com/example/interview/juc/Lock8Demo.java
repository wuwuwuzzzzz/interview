package com.example.interview.juc;

import java.util.concurrent.TimeUnit;

class Phone {

    public static synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------- sendEmail");
    }

    public static synchronized void sendSms() {
        System.out.println("---------- sendSMS");
    }

    public void hello() {
        System.out.println("---------- hello");
    }
}

/**
 *
 * @author wxz
 * @date 10:00 2022/12/30
 */
public class Lock8Demo {
    public static void main(String[] args) {

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone1.sendEmail();
        }, "A").start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            phone2.sendSms();
        }, "B").start();
    }
}
