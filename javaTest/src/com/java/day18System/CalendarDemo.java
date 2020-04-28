package com.java.day18System;

import com.java.SOP;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yiwang on 2018/6/22.
 */
public class CalendarDemo extends SOP{
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        sop(c.get(Calendar.YEAR)+"年");
        sop(c.get(Calendar.MONTH)+1+"月");
        sop(c.get(Calendar.DAY_OF_WEEK)+"日");
        sop("星期"+c.get(Calendar.DAY_OF_WEEK));

    }
}
