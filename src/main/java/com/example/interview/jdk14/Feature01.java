package com.example.interview.jdk14;


/**
 *
 * @author wxz
 * @date 16:07 2023/2/14
 */
public class Feature01 {

    public static void test1() {

        Object o = new String("hello");

        if (o instanceof String) {
            String str = (String)o;
            System.out.println(str.contains("Java"));
        } else {
            System.out.println("非String类型");
        }

//        if (o instanceof String str) {
//            System.out.println(str.contains("Java"));
//        }
    }

    public static void main(String[] args) {
        test1();
    }
}

class Monitor {

}
