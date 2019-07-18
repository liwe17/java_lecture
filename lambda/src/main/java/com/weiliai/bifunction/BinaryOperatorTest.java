package com.weiliai.bifunction;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author: Dog Li
 * @Date: 2019/7/18
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {

        BinaryOperatorTest test = new BinaryOperatorTest();
        System.out.println(test.compute(1, 2, (integer, integer2) -> integer + integer2));

        //打印大的哪一个字符串
        System.out.println(BinaryOperator.maxBy(String::compareTo).apply("123", "234"));

        //打印长度小的
        System.out.println(BinaryOperator.minBy(Comparator.comparingInt(String::length)).apply("AC", "ABC"));
        System.out.println(BinaryOperator.minBy((String a, String b) -> a.length() - b.length()).apply("AC", "ABC"));


    }

    public int compute(int a, int b,BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

}
