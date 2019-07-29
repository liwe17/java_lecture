package com.weiliai;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Doug Li
 * @Date: 2019/7/29
 * @Describe:流与集合List/Set互转
 */
public class StreamTest2 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        String[] strArray = stream.toArray(length -> new String[length]);
        Arrays.asList(strArray).forEach(System.out::println);
        String[] strArray2 = stream.toArray(String[]::new);
        Arrays.asList(strArray2).forEach(System.out::println);

        List<String> strList = stream.collect(Collectors.toList());
        List<String> strList2 = stream.collect(() -> new ArrayList<>(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
        List<String> strList3 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        strList.forEach(System.out::println);
        strList2.forEach(System.out::println);
        strList3.forEach(System.out::println);

        Set<String> treeSet = stream.collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);

        String strJoin = stream.collect(Collectors.joining());
        System.out.println(strJoin);

    }


}
