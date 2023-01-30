package com.example.interview.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Book {
    private int id;
    private String bookName;
}

/**
 *
 * @author wxz
 * @date 17:11 2023/1/30
 */
public class AtomicStampedDemo {
    public static void main(String[] args) {

    }
}
