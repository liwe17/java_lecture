package com.weiliai;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author: Doug Li
 * @Date: 2019/7/29
 * @Describe:generte/iterate的使用
 * IntSummaryStatistics辅助类
 */
public class StreamTest4 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);
        //无限流
        //stream.forEach(System.out::println);

        Stream.iterate(1,item->item+2).limit(6).forEach(System.out::println);
        //找出该流中大于2的元素,然后将每个元素乘以2,然后忽略掉流中的前两个元素,然后取流中的前两个元素,最后求出流中元素的总和
        System.err.println(Stream.iterate(1, item -> item + 2).limit(6).filter(e -> e > 2).map(e -> e * 2).skip(2).limit(2).reduce(Integer::sum));
        System.err.println(Stream.iterate(1, item -> item + 2).limit(6).filter(e -> e > 2).mapToInt(e -> e * 2).skip(2).limit(2).sum());
        Stream.iterate(1, item -> item + 2).limit(6).filter(e -> e > 2).mapToInt(e -> e * 2).skip(2).limit(2).min().ifPresent(System.out::println);
        //辅助类
        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(e -> e > 2).mapToInt(e -> e * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());

        //注意流被二次使用会报错
        Stream<Integer> stream2 = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream2);
        System.out.println(stream2.filter(e->e>2));
        System.out.println(stream2.distinct());
    }
}
