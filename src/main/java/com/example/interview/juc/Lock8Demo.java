package com.example.interview.juc;

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
    }
}
