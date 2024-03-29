package com.example.interview.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wxz
 * @date 10:04 2023/2/13
 */
public class StreamDemo
{

    public static void main(String[] args)
    {

        List<Author> authorList = getAuthors();

        authorList.stream()
                  .distinct()
                  .filter(author -> author.getAge() < 18)
                  .forEach(author -> System.out.println(author.getName()));

        //        authorList.stream()
        //                  .distinct()
        //                  .forEach(System.out::println);

        //        authorList.stream()
        //                  .distinct()
        //                  .sorted()
        //                  .forEach(author -> System.out.println(author.getAge()));

        //        authorList.stream()
        //                  .distinct()
        //                  .sorted((o1, o2) -> o2.getAge() - o1.getAge())
        //                  .forEach(author -> System.out.println(author.getAge()));

        //        authorList.stream()
        //                  .distinct()
        //                  .sorted((o1, o2) -> o2.getAge() - o1.getAge())
        //                  .limit(2)
        //                  .forEach(author -> System.out.println(author.getName()));

        //        authorList.stream()
        //                  .distinct()
        //                  .sorted((o1, o2) -> o2.getAge() - o1.getAge())
        //                  .skip(1)
        //                  .forEach(author -> System.out.println(author.getName()));

        //        authorList.stream()
        //                  .flatMap(author -> author.getBooks().stream())
        //                  .distinct()
        //                  .forEach(book -> System.out.println(book.getName()));

        //        authorList.stream()
        //                  .flatMap(author -> author.getBooks().stream())
        //                  .distinct()
        //                  .flatMap(book -> Arrays.stream(book.getCategory().split("，")))
        //                  .distinct()
        //                  .forEach(System.out::println);

        //        authorList.stream().map(author -> author.getName()).distinct().forEach(name -> System.out.println(name));

        //        authorList.stream()
        //                  .flatMap(author -> author.getBooks().stream())
        //                  .distinct()
        //                  .count();
        //        Optional<Integer> max = authorList.stream()
        //                                          .flatMap(author -> author.getBooks().stream())
        //                                          .map(book -> book.getScore())
        //                                          .max((o1, o2) -> o1 - o2);
        //        System.out.println(max.get());

        //        List<String> list = authorList.stream().map(author -> author.getName()).distinct().collect(Collectors.toList());
        //        System.out.println(list);

        //        System.out.println(
        //            authorList.stream().flatMap(author -> author.getBooks().stream()).collect(Collectors.toSet()));
        //
        //        System.out.println(
        //            authorList.stream().distinct().collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks())));

        //        authorList.stream()
        //                  .anyMatch(author -> author.getAge() > 29);

        //        System.out.println(authorList.stream().allMatch(author -> author.getAge() > 18));

        //        authorList.stream()
        //                  .noneMatch(author -> author.getAge() < 100);

        //        authorList.stream()
        //                  .filter(author -> author.getAge() > 18)
        //                  .findAny()
        //                  .ifPresent(author -> System.out.println(author.getName()));

        //        authorList.stream()
        //                  .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
        //                  .findFirst()
        //                  .ifPresent(author -> System.out.println(author.getAge()));

        //        int[] arr = {1, 2, 3, 4, 5};
        //        authorList.stream()
        //                  .map(author -> author.getAge())
        //                  .reduce((integer, integer2) -> integer + integer2)
        //                  .ifPresent(age -> System.out.println(age));

        //        Author author = new Author();
        //        author.setName("wxz");
        //        author.setAge(2);
        //        Optional.of(author)
        //                .ifPresent(author1 -> System.out.println(author1.getName()));
        //        System.out.println(Optional.ofNullable(author).filter(author1 -> author1.getAge() > 18));

        //        if (Optional.ofNullable(author).isPresent()) {
        //            System.out.println(Optional.ofNullable(author).get().getName());
        //        }
        //        Optional.ofNullable(author)
        //                .map(author1 -> author1.getBooks())
        //                .ifPresent(books -> System.out.println(books));

        //        authorList.stream()
        //                  .filter(
        //                      ((Predicate<Author>)author -> author.getAge() > 18).and(author -> author.getName().length() > 1))
        //                  .forEach(System.out::println);

        //        StringBuilder sb = new StringBuilder();
        //        authorList.stream()
        //                  .map(author -> author.getName())
        //            .forEach(sb::append);

        //        authorList.stream()
        //                  .map(Author::getName)
        //                  .map(StringBuilder::new);

        //        authorList.stream()
        //                  .mapToInt(Author::getAge)
        //                  .map(age -> age + 10)
        //                  .filter(age -> age > 18)
        //                  .map(age -> age + 2)
        //                  .forEach(System.out::println);

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        stream.parallel()
              .peek(integer -> System.out.println(integer + " " + Thread.currentThread()
                                                                        .getName()))
              .filter(num -> num > 5)
              .reduce(Integer::sum)
              .ifPresent(System.out::println);
    }

    private static List<Author> getAuthors()
    {

        // 数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        List<Book> book1 = new ArrayList<>();
        List<Book> book2 = new ArrayList<>();
        List<Book> book3 = new ArrayList<>();

        book1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学，爱情", 88, "用一把刀划分了爱恨"));
        book1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长，爱情", 99, "讲述如何从失败走向成功"));

        book2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        book2.add(new Book(4L, "吹或不吹", "爱情，个人传记", 56, "一个哲学家的恋爱观注定很难成功"));

        book3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这样"));
        book3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花"));
        book3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花"));

        author.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book3);

        return new ArrayList<>(Arrays.asList(author, author2, author3, author4));
    }
}
