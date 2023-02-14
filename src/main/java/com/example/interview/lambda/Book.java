package com.example.interview.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author wxz
 * @date 10:01 2023/2/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    private Long id;

    private String name;

    private String category;

    private Integer score;

    private String intro;
}
