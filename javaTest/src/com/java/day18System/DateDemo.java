package com.java.day18System;

import com.java.SOP;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo extends SOP{
    public static void main(String[] args){
        Date d = new Date();
        sop(d);
        SimpleDateFormat s =new SimpleDateFormat("yyyy年MM月dd日E hh:mm:ss");
        String time = s.format(d);
        sop(time);
    }
}
