package com.example.interview.juc;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author wxz
 * @date 14:39 2022/12/29
 */
public class CompletableFutureMall2Demo {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dd"),
            new NetMall("tb")

    );

    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list.stream().map(netMall -> String.format(productName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(productName))).collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() ->
            String.format(productName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(productName))
        )).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println(ThreadLocalRandom.current().nextDouble() * 2 + "mysql".charAt(0));

        long startTime = System.currentTimeMillis();
        List<String> list1 = getPrice(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("耗时: " + (endTime - startTime) + "毫秒");

        long startTime1 = System.currentTimeMillis();
        List<String> list2 = getPriceByCompletableFuture(list, "mysql");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime1 = System.currentTimeMillis();

        System.out.println("耗时: " + (endTime1 - startTime1) + "毫秒");
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
