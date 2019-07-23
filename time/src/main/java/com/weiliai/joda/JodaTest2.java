package com.weiliai.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author: Doug Li
 * @Date: 2019/7/22
 * @Describe:
 */
public class JodaTest2 {

    //标准UTC时间: Z代表无时区:2014-11-03T09:00:00.876Z; 有时区: 2014-11-03T09:00:00.876+08:00
    public static Date convertUTC2Date(String utcDate){
        Date date = null;
        try {
            DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            date = dateTime.toDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String convertDate2UTC(Date javaDate){
        String dateStr = null;
        try {
            DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
            dateStr = dateTime.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String convertDate2LocalByDateFormat(Date javaDate,String dateFormat){
        String dateStr = null;
        try {
            DateTime dateTime = new DateTime(javaDate);
            dateStr = dateTime.toString(dateFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static void main(String[] args) {
        System.out.println(JodaTest2.convertUTC2Date("2018-11-11T09:00:00.996Z"));
        System.out.println(JodaTest2.convertDate2UTC(new Date()));
        System.out.println(JodaTest2.convertDate2LocalByDateFormat(new Date(),"yyyy=MM-dd HH:mm:ss"));
        System.out.println(JodaTest2.convertDate2LocalByDateFormat(new Date(),"yyyy=MM-dd HH:mm:ss"));
    }



}
