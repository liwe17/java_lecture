package com.weiliai;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Doug Li
 * @Date: 2019/7/29
 * @Describe:并行和串行流以及流短路
 */
public class StreamTest6 {

    public static void main(String[] args) {
        List<String> list = Stream.generate(UUID.randomUUID()::toString).limit(5000000).collect(Collectors.toList());
        System.out.println("串行流开始排序");
        long startTime = System.nanoTime();
        List<String> list2 = list.stream().sorted().collect(Collectors.toList());
        System.err.println(list2.size());
        System.out.println("串行流排序结束");
        long endTime = System.nanoTime();
        System.out.println("串行流耗时:"+ TimeUnit.NANOSECONDS.toMillis(endTime-startTime));

        List<String> list3 = Stream.generate(() -> UUID.randomUUID().toString()).limit(5000000).collect(Collectors.toList());
        System.out.println("并行流开始排序");
        long startTime2 = System.nanoTime();
        List<String> list4 = list3.parallelStream().sorted().collect(Collectors.toList());
        System.err.println(list4.size());
        System.out.println("并行流排序结束");
        long endTime2 = System.nanoTime();
        System.out.println("并行流耗时:"+ TimeUnit.NANOSECONDS.toMillis(endTime2-startTime2));

        List<String> list5 = Arrays.asList("hello", "world", "hello world");
        //list5.stream().filter(e->e.length()==5).forEach(System.out::println);
        //list5.stream().mapToInt(e->e.length()).filter(e->e==5).findFirst().ifPresent(System.out::println);

        /**
         * 执行结果:短路
         * hello
         * 5
         */
        list5.stream().mapToInt(e->{
            int length = e.length();
            System.out.println(e);
            return length;
        }).filter(e->e==5).findFirst().ifPresent(System.out::println);
        System.out.println("=========华丽的分割符=====================");
        List<String> list6 = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        //去重的两种方式-本质一样
        list6.stream().flatMap(e -> Arrays.stream(e.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        list6.stream().map(e->e.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

}
