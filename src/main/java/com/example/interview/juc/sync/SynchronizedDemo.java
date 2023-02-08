package com.example.interview.juc.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 16:45 2023/2/7
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Object o = new Object();

        synchronized (o) {
            System.out.println(o.hashCode());
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
