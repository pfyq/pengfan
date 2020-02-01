/* 
 *
 * Copyright (C) 1999-2012 IFLYTEK Inc.All Rights Reserved. 
 * 
 * FileName��TimeUtil.java
 * 
 * Description��
 * 
 * History��
 * Version   Author      Date            Operation 
 * 1.0	  15895085799   2018-1-19����10:24:34	       Create	
 */
package com.qp.smark.util;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * @author 15895085799
 * @create 2018-1-19 上午10:24:34
 * @version 1.0
 * @since 1.0
 */
public class TimeUtil {
    private final static Logger log = Logger.getLogger(TimeUtil.class);
    private static SimpleDateFormat sdf = null;
    public final static String format1 = "yyyy-MM-dd";//时间格式1
    public final static String format2 = "yyyy-MM-dd hh:mm:ss";//时间格式2
    /*得到当前时间戳
     * */
    public static long getTimeMillis(){
        return new Date().getTime();
    }

    /*得到当前时间的前几天时间
     * */
    public static String getBeforeDay(int dt,String format){
        sdf = new SimpleDateFormat(format);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,dt);
        Date startDate = calendar.getTime();
        return sdf.format(startDate);
    }

    /*判断是否是时间
     * */
    public static boolean isDateFormat(String str,String format){
        boolean convertSuccess=true;
        sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }
    /*得到前一天时间
     * */
    public static String beforeOneDate(String dateStr,String format){
        sdf = new SimpleDateFormat(format);
        Date date = null;
        Date startDate = null;
        try {
            date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE,-1);
            startDate = calendar.getTime();
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return sdf.format(startDate);
    }
    /*两个时间相差多少天
     * */
    public static int differentDays(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2){   //同一年
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++){
                if(i%4==0 && i%100!=0 || i%400==0){    //闰年
                    timeDistance += 366;
                }else{    //不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2-day1) ;
        }else{    //不同年
            return day2-day1;
        }
    }
    /*当前时间
     * */
    public static String getCurrDate(String format){
        SimpleDateFormat s = new SimpleDateFormat(format);
        return s.format(new Date());
    }

    //字符串转日期
    public static Date strConvertDate(String time,String format){
        SimpleDateFormat s = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = s.parse(time);
        } catch (ParseException e) {
            log.error(e.getMessage(),e);
        }
        return date;
    }

    //时间转字符
    public static String dateConvertStr(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate
     * @param toDate
     * @return
     */
    public static DayCompare dayComparePrecise(Date fromDate,Date toDate){
        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);

        int year = toYear  -  fromYear;
        int month = toMonth  - fromMonth;
        int day = toDay  - fromDay;
        return DayCompare.builder().day(day).month(month + year*12).build();
//        return DayCompare.builder().day(day).month(month).year(year).build();
    }

    /*获取两个时间相差多少天多少个月*/
    public static DayCompare getDiff(LocalDate start, LocalDate end) {
        if (!start.equals(end)&&!start.isBefore(end)) {
            throw new IllegalArgumentException("Start must not be before end.");
        }

        Period period = Period.between(start, end);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        return DayCompare.builder().day(days).month(years * 12 + months).build();
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    /*
    * 特殊时间处理:2019-01-31T16:00:00.000+0000
    * */
    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }


}
