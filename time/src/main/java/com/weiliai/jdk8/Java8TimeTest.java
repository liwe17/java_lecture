package com.weiliai.jdk8;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: Dog Li
 * @Date: 2019/7/20
 */
public class Java8TimeTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(+localDate.getYear()+"年"+localDate.getMonthValue()+"月"+localDate.getDayOfMonth()+"日");
        LocalDate localDate2 = LocalDate.of(2017, 3, 3);
        System.out.println(localDate2);
        //日期的加减
        LocalDate localDate4 = localDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate4);
        LocalDate localDate5 = localDate.minus(2, ChronoUnit.DAYS);
        System.out.println(localDate5);
        //日期比较
        LocalDate localDate6 = LocalDate.now();
        LocalDate localDate7 = LocalDate.of(2000, 07, 21);
        System.out.println(localDate6.isEqual(localDate7));
        System.out.println(localDate6.isAfter(localDate7));
        System.out.println(localDate6.isBefore(localDate7));
        //是否是闰年
        System.out.println(localDate6.isLeapYear());
        System.out.println(localDate7.isLeapYear());
        System.out.println("======华丽的分割线(周期)=======");
        LocalDate localDate9 = LocalDate.of(2000, 2, 29);
        LocalDate localDate10 = LocalDate.of(2001, 2, 28);
        Period period = Period.between(localDate9, localDate10);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(ChronoUnit.DAYS.between(localDate9, localDate10));
        System.out.println("======华丽的分割线(年月日)=======");
        MonthDay monthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2001, 2, 28));
        if(monthDay.equals(monthDay2)){
            System.out.println("equals");
        }else{
            System.out.println("not equals");
        }
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfYear());
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.getMonth().firstDayOfYear(yearMonth.isLeapYear()));
        System.out.println(yearMonth.isLeapYear());
        YearMonth yearMonth2 = YearMonth.of(2000,8);
        System.out.println(yearMonth2);
        System.out.println(yearMonth2.lengthOfYear());
        System.out.println(yearMonth2.lengthOfMonth());
        System.out.println(yearMonth2.getMonth().firstDayOfYear(yearMonth2.isLeapYear()));
        System.out.println(yearMonth2.isLeapYear());
        System.out.println("======华丽的分割线(时分秒TIME)=======");
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime time2 = time.plusHours(3).plusMinutes(20);
        System.out.println(time2);
        System.out.println("======华丽的分割线(瞬时CLOCK)=======");
        //Clock时钟
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        System.out.println("======华丽的分割线(时区)=======");
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        //zoneIds.forEach(System.out::println);
        //排序
        TreeSet<String> treeSet = new TreeSet<String>(){
            {
                addAll(zoneIds);
            }
        };
        treeSet.stream().forEach(System.out::println);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
        System.out.println("======华丽的分割线(Instant)=======");
        System.out.println(Instant.now());
    }

}
