package com.weiliai.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author: Dog Li
 * @Date: 2019/7/17
 */
public class BiFunctionTest {

    public static void main(String[] args) {

        BiFunctionTest test = new BiFunctionTest();

        System.out.println(test.compute(1,2,(value1,value2)->value1 + value2));
        System.out.println(test.compute(1,2,(value1,value2)->value1 - value2));
        System.out.println(test.compute(1,2,(value1,value2)->value1 * value2));
        System.out.println(test.compute(1,2,(value1,value2)->value1 / value2));

        System.out.println(test.compute2(2,3,(value1,value2)->value1 + value2,value->value * value));

    }

    public int compute(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }

    public int compute2(int a, int b, BiFunction<Integer,Integer,Integer> biFunction, Function<Integer,Integer> function){
        return biFunction.andThen(function).apply(a,b);
    }

}
