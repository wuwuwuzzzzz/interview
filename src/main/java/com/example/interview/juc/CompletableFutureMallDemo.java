package com.example.interview.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author wxz
 * @date 14:21 2022/12/29
 */
public class CompletableFutureMallDemo {
    public static void main(String[] args) {
        Student student = new Student();
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Student {
    private Integer id;
    private String name;
    private String major;
}
