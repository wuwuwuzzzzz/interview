package com.example.interview.juc.objecthead;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 *
 * @author wxz
 * @date 14:59 2023/2/7
 */
public class JolDemo {
    public static void main(String[] args) {

        // Vm的细节详细信息
        System.out.println(VM.current().details());

        // 所有对象的分配的字节都是8的整数倍
        System.out.println(VM.current().objectAlignment());

        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Custom custom = new Custom();

        System.out.println(ClassLayout.parseInstance(custom).toPrintable());
    }
}

class Custom {

    int id;

    boolean flag = false;
}
