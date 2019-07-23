package com.weiliai.function;

import java.util.function.Function;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(1,value->{return 2 * value;}));
        System.out.println(test.compute(2,value->5 + value));
        System.out.println(test.compute(3,value->value + value));

        System.out.println(test.convert(5,value->value+"Hello World"));
        System.out.println(test.method1(1));
        System.out.println(test.method2(2));
        System.out.println(test.method3(3));
    }

    public int compute(int a, Function<Integer,Integer> function){
        int result = function.apply(a);
        return result;
    }

    public String convert(int a,Function<Integer,String> function){
        return function.apply(a);
    }

    public int method1(int a){
        return 2 * a;
    }

    public int method2(int a){
        return 5 + a;
    }

    public int method3(int a){
        return a * a;
    }

}
