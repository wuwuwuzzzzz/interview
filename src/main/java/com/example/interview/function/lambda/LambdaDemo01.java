package com.example.interview.function.lambda;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @author wxz
 * @date 12:20 2023/2/12
 */
public class LambdaDemo01 {
    public static void main(String[] args) {

        //        new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                System.out.println("新线程中run方法被执行了");
        //            }
        //        }).start();
        //
        //        new Thread(() -> {
        //            System.out.println("新线程中run方法被执行了");
        //        }).start();

        //        int i = calculateNum((int left, int right) -> left + right);
        //        System.out.println(i);

//        printNum(value -> value % 2 == 0);
    }

    public static int calculateNum(IntBinaryOperator operation) {
        int a = 10;
        int b = 20;
        return operation.applyAsInt(a, b);
    }

    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}
