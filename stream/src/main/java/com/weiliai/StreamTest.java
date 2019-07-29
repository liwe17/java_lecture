package com.weiliai;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:初步了解
 */
public class StreamTest {

    public static void main(String[] args) {
        //三种创建流的方式
        Stream<String> stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = {"hello", "world", "hello world"};
        Stream<String> stream2 = Stream.of(myArray);
        Stream<String> stream3 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream<String> stream4 = list.stream();
        System.out.println("===============华丽的分割线===================");
        //数字流
        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);
        IntStream.range(3,8).forEach(System.out::println);
        IntStream.rangeClosed(3,8).forEach(System.out::println);
        System.out.println("==============华丽的分割线===================");
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        intList.forEach(System.out::println);
        System.err.println(intList.stream().map(e -> e * 2).reduce(0, Integer::sum));
    }

}
