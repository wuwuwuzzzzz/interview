package com.example.interview.jdk14;

import java.util.ArrayList;

/**
 *
 * @author wxz
 * @date 13:54 2023/2/15
 */
public class Feature04 {
    public static void main(String[] args) {

        ArrayList<byte[]> list = new ArrayList<>();

        while (true) {
            byte[] data = new byte[100];
            list.add(data);
        }
    }
}
