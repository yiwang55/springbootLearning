package com.java.day18System;


import com.java.SOP;

import java.util.Properties;

public class SystemDemo extends SOP{
    public static void main(String[] args){
//        Properties prop = System.getProperties();

        System.setProperty("myKey","myValue");

        String value = System.getProperty("os.name");
        sop(value);
//        for(Object obj : prop.keySet()){
//            String value = (String)prop.get(obj);
//            sop(value);
//        }

    }
}
