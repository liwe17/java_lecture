package com.weiliai;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Doug Li
 * @Date: 2019/7/29
 * @Describe: map/flatMap的使用
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld", "test");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list2.stream().map(e->e*e).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(list2.stream().map(e -> e * e).reduce(Integer::sum).orElse(0));

        Stream<List<Integer>> list3 = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        list3.flatMap(theList->theList.stream().map(e->e*e)).forEach(System.out::println);


    }

}
