package com.example.interview.jdk14;

import java.util.ArrayList;

/**
 * @author wxz
 * @date 11:46 2023/2/15
 */
public class Feature02 {
    public static void main(String[] args) {

        String x = "3";

        int num = switch (x)  {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            default -> {
                System.out.println("default");
                yield 4;
            }
        };

    }
}
