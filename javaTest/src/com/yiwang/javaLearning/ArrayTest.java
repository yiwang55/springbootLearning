package com.yiwang.javaLearning;

/*
 ����һ������{5,1,6,4,2,8,9}
 1.��ȡ�����е����ֵ����Сֵ��
 * */

class ArrayTest {
	public static int getMax(int[] arry){
		int max = arry[0];
		for(int i = 1; i < arry.length; i++) {
			if (arry[i] > max) {
				max = arry[i];
			}
		}
		return max;
	} 
	
	public static int getMin(int[] arry){
		int min = arry[0];
		for(int i = 1; i < arry.length; i++) {
			if (arry[i] < min) {
				min = arry[i];
			}
		}
		return min;
	}

	public static int getMax_2(int[] arry){
		int max = 0;
		for(int i = 1; i < arry.length; i++) {
			if (arry[i] > arry[max]) {
				max = i;
			}
		}
		return arry[max];
	} 

//	public static double getMax(double[] arry){
//	} ��������  ����һ�����������Ͳ�ͬ��
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,6,20,4,2,8,9};
		
		int max = getMax_2(arr);
		int min = getMin(arr);
		System.out.println(max);
		System.out.println(min);
	}
}