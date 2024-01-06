package com.example.interview.lambda;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wxz
 * @date 22:03 2024/1/6
 */
public class StreamDemo2
{
    /**
     * @author wxz
     * @date 22:03 2024/1/6
     */
    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", Arrays.asList("reading", "music")));
        persons.add(new Person("Bob", Arrays.asList("sports", "movies")));

        List<String> allHobbies = persons.stream()
                                         .flatMap(person -> person.getHobbies().stream())
                                         .collect(Collectors.toList());
        System.out.println(allHobbies);
    }

    /**
     * Person 测试类
     *
     * @author wxz
     * @date 22:05 2024/1/6
     */
    @Data
    static class Person
    {
        private String name;

        private List<String> hobbies;

        public Person(String name, List<String> hobbies)
        {
            this.name = name;
            this.hobbies = hobbies;
        }

    }
}
