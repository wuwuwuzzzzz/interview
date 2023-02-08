package com.example.interview.juc.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 *
 * @author wxz
 * @date 16:45 2023/2/7
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

        Object o = new Object();

        System.out.println(o.hashCode());

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
