package com.example.interview.function.lambda;

/**
 *
 * @author wxz
 * @date 12:20 2023/2/12
 */
public class LambdaDemo01 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中run方法被执行了");
            }
        }).start();
    }
}
