package com.autohome.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: HungryApi
 * @description: 日期
 * @author: Jerry(姜源)
 * @create: 2020-06-19 10:01
 */
public class DateUtil {
    /**
     * @param com  要进行操作的值
     * @param type 日历字段*/
    public static Date comDate(int type,int com){
        Calendar calendar=Calendar.getInstance();
        calendar.add(type,com);
        return calendar.getTime();
    }
}
