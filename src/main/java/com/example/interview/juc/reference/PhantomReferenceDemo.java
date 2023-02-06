package com.example.interview.juc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 11:33 2023/2/6
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {

        MyObject myObject = new MyObject();

        ReferenceQueue<MyObject> queue = new ReferenceQueue<MyObject>();

        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, queue);

        System.out.println(phantomReference.get());

        List<byte[]> list = new ArrayList<byte[]>();

        new Thread(() -> {
            while (true) {
                list.add(new byte[1 * 1024 * 1024]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(phantomReference.get() + "\t" + "list add ok");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                Reference<? extends MyObject> poll = queue.poll();
                if (poll != null) {
                    System.out.println("有虚引用对象被回收加入了队列");
                    break;
                }
            }
        }, "t1").start();
    }
}
