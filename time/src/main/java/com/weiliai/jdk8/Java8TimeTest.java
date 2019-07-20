package com.weiliai.jdk8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

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
        System.out.println("======华丽的分割线1=======");
        LocalDate localDate3 = LocalDate.of(2000, 2, 29);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2001, 2, 28));
        if(monthDay.equals(monthDay2)){
            System.out.println("equals");
        }else{
            System.out.println("not equals");
        }
        System.out.println("======华丽的分割线2=======");
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalTime time2 = time.plusHours(3).plusMinutes(20);
        System.out.println(time2);
    }

}
