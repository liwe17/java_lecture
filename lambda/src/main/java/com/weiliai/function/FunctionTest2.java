package com.weiliai.function;

import java.util.function.Function;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
public class FunctionTest2 {

    public static void main(String[] args) {

        FunctionTest2 test = new FunctionTest2();
        System.out.println(test.compute(2,value->value * 2,value->value * value)); //8
        System.out.println(test.compute2(2,value->value * 3,value->value * value));//36

    }

    //先执行function2,在执行function1
    public int compute(int a, Function<Integer,Integer>function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }

    //先执行function1,在执行function2
    public int compute2(int a,Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

}