package com.example.interview.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author wxz
 * @date 09:57 2023/2/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author> {

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 简介
     */
    private String intro;

    /**
     * 作品
     */
    private List<Book> books;

    @Override
    public int compareTo(Author o) {
        return this.getAge() - o.getAge();
    }
}
