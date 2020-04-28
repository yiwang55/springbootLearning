package com.java.day18System;

import com.java.SOP;

import java.util.Random;

/**
 * Created by yiwang on 2018/6/22.
 */
public class MathTest extends SOP{
    public static void main(String[] args){
        for (int x = 0; x<10; x++){
            RetainDouble(Math.random());
        }
    }
    public static void RetainDouble(Double d){
//        d = d * 100;
//        int l = (int)d;
//        l = l/100;
//        sop(l);
    }
}
