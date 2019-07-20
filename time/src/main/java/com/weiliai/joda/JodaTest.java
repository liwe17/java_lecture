package com.weiliai.joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @author: Dog Li
 * @Date: 2019/7/20
 */
public class JodaTest {

    public static void main(String[] args) {
        //DateTime 对象
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);
        System.out.println("今天是:"+ today.toString());
        System.out.println("明天是:"+ tomorrow.toString());
        System.out.println("yyyy-MM-dd是:"+ today.toString("yyyy-MM-dd"));
        System.out.println("yyyy-MM-dd是:"+ tomorrow.toString("yyyy-MM-dd"));
        DateTime d1 = today.withDayOfMonth(1);
        System.out.println("当月第一天是:"+d1.toString("yyyy-MM-dd"));
        System.out.println("-----华丽丽的分割线1------");
        //计算2年前第三个月后的最后一天的日期
        DateTime dateTime = new DateTime();
        DateTime dateTime2 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMaximumValue();
        System.out.println(dateTime2);
        System.out.println("-----华丽丽的分割线2------");
        //LocalDate 对象
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        //获取3个月后最后一天
        LocalDate localDate2 = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate2);
        System.out.println("-----华丽丽的分割线3------");
    }
}
