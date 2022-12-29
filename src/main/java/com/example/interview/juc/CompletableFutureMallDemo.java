package com.example.interview.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author wxz
 * @date 14:21 2022/12/29
 */
public class CompletableFutureMallDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Student student = new Student();
        student.setId(1).setName("z3").setMajor("cs");
        System.out.println(student);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });

        System.out.println(completableFuture.get());
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
class Student {
    private Integer id;
    private String name;
    private String major;
}
