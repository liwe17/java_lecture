package com.weiliai;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: Doug Li
 * @Date: 2019/7/29
 * @Describe:
 */
public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        //首字母大写
        list.stream().map(e->e.substring(0,1).toUpperCase()+e.substring(1)).forEach(System.out::println);

        //不执行foreach,不会进行操作
        list.stream().map(e->{
            String result = e.substring(0,1).toUpperCase()+e.substring(1);
            System.out.println("test");
            return result;
        }).forEach(System.out::println);

        //死循环,只有0,1,不可能有6个结果,所以distinct会一直等待
        IntStream.iterate(0,i->(i + 1) % 2).distinct().limit(6).forEach(System.out::println);
    }
}
