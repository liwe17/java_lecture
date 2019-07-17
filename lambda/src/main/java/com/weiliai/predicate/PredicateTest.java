package com.weiliai.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: Dog Li
 * @Date: 2019/7/17
 */
public class PredicateTest {

    public static void main(String[] args) {
        //简单测试
        Predicate<String> predicate = p->p.length()>5;
        System.out.println(predicate.test("hello world"));

        PredicateTest test = new PredicateTest();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("=================================");
        test.conditionFilter(list,integer -> integer % 2 ==0);
        test.findAllEvens(list);
        System.out.println("=================================");
        test.conditionFilter(list,integer -> integer % 2 !=0);
        System.out.println("=================================");
        test.conditionFilter(list,integer -> integer > 5);
        System.out.println("=================================");
        test.conditionFilter(list,integer -> integer < 3);
        System.out.println("=================================");
        test.conditionFilter(list,integer -> true);
        System.out.println("=================================");
        test.conditionFilter2(list,integer -> integer>5,integer -> integer % 2==0);
        System.out.println("=================================");
        test.conditionFilter3(list,integer -> integer>5,integer -> integer % 2==0);
        System.out.println("===============有惊喜============");
        test.conditionFilter4(list,integer -> integer>5,integer -> integer % 2 ==0);
        System.out.println("===============有惊喜============");
        System.out.println(test.isEqual("test").test("test"));
    }

    public void conditionFilter(List<Integer> list,Predicate<Integer> predicate){
        for (Integer integer : list) {
            if(predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

    // &&且
    public void conditionFilter2(List<Integer> list,Predicate<Integer> predicate,Predicate<Integer> predicate2){
        for (Integer integer : list) {
            if(predicate.and(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }


    // ||或
    public void conditionFilter3(List<Integer> list,Predicate<Integer> predicate,Predicate<Integer> predicate2){
        for (Integer integer : list) {
            if(predicate.or(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFilter4(List<Integer> list,Predicate<Integer> predicate,Predicate<Integer> predicate2){
        for (Integer integer : list) {
            if(predicate.and(predicate2).negate().test(integer)){
                System.out.println(integer);
            }
        }
    }

    public Predicate<String> isEqual(Object object){
        return Predicate.isEqual(object);
    }


    public void findAllEvens(List<Integer> list){
        for (Integer integer : list) {
            if(integer%2==0){
                System.out.println(integer);
            }
        }
    }
}
