package com.java.day17Collections;

import com.java.SOP;

import java.util.Arrays;

import static java.util.Arrays.*;

import static java.lang.System.*;
/***
 * 静态导入
 * **/
public class StaticImport extends SOP{
    public static void main(String[] args){
        out.println("haha");

        int[] arr = {3,1,4,5};
        sort(arr);
        int index = binarySearch(arr,1);
        sop(index);
        sop(Arrays.toString(arr));
    }
}
