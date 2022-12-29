package com.example.interview.juc;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 14:39 2022/12/29
 */
public class CompletableFutureMall2Demo {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dd"),
            new NetMall("tb")

    );

    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextDouble() * 2 + "mysql".charAt(0));
    }
}

@AllArgsConstructor
class NetMall {

    @Getter
    private String netMallName;

    public void setNetMallName(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
