package com.weiliai.optional;

import java.util.Optional;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
public class OptionalTest {

    public static void main(String[] args) {
        //三种构造方法
        Optional<String> optiona = Optional.ofNullable("hello");
        Optional<String> optiona3 = Optional.of("hello");
        Optional<String> optiona4 = Optional.empty();
        // 原始方式
        if(optiona.isPresent()){
            System.out.println(optiona.get());
        }

        //函数式编程
        optiona.ifPresent(item-> System.out.println(item));

        Optional<String> optional2 = Optional.empty();
        System.out.println(optional2.orElse("word"));

        System.out.println(optional2.orElseGet(() -> "nihao"));
    }
}
