package com.weiliai;

import java.util.*;
import java.util.function.Function;

/**
 * @author: Dog Li
 * @Date: 2019/7/11
 */
public class Test {

    public static void main(String[] args){

        //()->{};需要上下文断定

        MyInterface my1 = ()->{};
        System.out.println(my1.getClass().getInterfaces()[0]);

        MyInterface2 my2 =()->{};
        System.out.println(my2.getClass().getInterfaces()[0]);

        //快速启动一个线程
        new Thread(()->{System.out.println("Hello world");},"thread1").start();

        List<String> list = Arrays.asList("hello","world","hello world");
        System.out.println("==========================================");
        //遍历集合并将内容大写
        list.forEach(e->System.out.println(e.toUpperCase()));
        System.out.println("==========================================");
        //将list放入到list2
        List<String> list2 = new ArrayList<>();
        list.forEach(e->list2.add(e.toUpperCase()));
        list2.forEach(e-> System.out.println(e));
        System.out.println("==========================================");
        //map功能函数,将list放入到list2
        list.stream().map(e->e.toUpperCase()).forEach(e->list2.add(e));
        list2.forEach(e-> System.out.println(e));
        System.out.println("==========================================");
        list.stream().map(String::toUpperCase).forEach(e-> list2.add(e));
        list2.forEach(e-> System.out.println(e));

        //方法引用
        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
        System.out.println("==========================================");
        //方法引用
        List<String> names =  Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        Collections.sort(names,(e1,e2)->e1.compareTo(e2));
        Collections.sort(names,String::compareTo);
    }

}

@FunctionalInterface
interface MyInterface {

    void myMethod();
}

@FunctionalInterface
interface MyInterface2{
    void myMethod2();
}