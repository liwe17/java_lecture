package com.weiliai.bifunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author: Dog Li
 * @Date: 2019/7/17
 */
public class PersonTest {

    public static void main(String[] args) {

        PersonTest test = new PersonTest();

        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1,person2,person3);
        System.out.println("==========================================================================");
        test.getPersonsByUserName("zhangsan",persons).forEach(e-> System.out.println(e));
        System.out.println("==========================================================================");
        test.getPersonsByAge(25,persons).forEach(System.out::println);
        System.out.println("==========================================================================");
        test.getPersonsByAge2(15,persons,(age,personList)->personList.stream().filter(person -> person.getAge()>age).collect(Collectors.toList())).forEach(System.out::println);


    }

    //自己实现
    public List<Person> getPersonsByUserName(String username,List<Person> persons){
        return persons.stream().filter(person -> person.getName().equals(username)).collect(Collectors.toList());
    }

    //通过函数实现
    public List<Person> getPersonsByAge(int age,List<Person> persons) {
        /*
        BiFunction<Integer, List<Person>, List<Person>> biFunction2 = (ageofPerson, personList) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        };
        */
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageofPerson, personList) ->personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        return biFunction.apply(age,persons);
    }

    //根据传入的函数的实现
    public List<Person> getPersonsByAge2(int age,List<Person> persons,BiFunction<Integer,List<Person>,List<Person>> biFunction) {
        return biFunction.apply(age,persons);
    }

}