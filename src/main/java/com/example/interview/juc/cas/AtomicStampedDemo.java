package com.example.interview.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicStampedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Book {
    private int id;
    private String bookName;
}

/**
 * @author wxz
 * @date 17:11 2023/1/30
 */
public class AtomicStampedDemo {
    public static void main(String[] args) {

        Book book = new Book(1, "book");
        AtomicStampedReference<Book> stampedReference = new AtomicStampedReference<>(book, 1);
        System.out.println(stampedReference.getReference() + "\t" + stampedReference.getStamp());

        Book book2 = new Book(2, "book2");
        boolean b;
        b = stampedReference.compareAndSet(book, book2, stampedReference.getStamp(), stampedReference.getStamp() + 1);
        System.out.println(b + "\t" + stampedReference.getReference() + "\t" + stampedReference.getStamp());
        b = stampedReference.compareAndSet(book2, book, stampedReference.getStamp(), stampedReference.getStamp() + 1);
        System.out.println(b + "\t" + stampedReference.getReference() + "\t" + stampedReference.getStamp());
    }
}
