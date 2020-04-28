package com.java.day11Thread;

class Test1 implements Runnable{
    private boolean flag;
    Test1(boolean flag){
        this.flag = flag;
    }
    public void run (){
        if (flag){
            while(true){
            synchronized (MyLock.locka){
                System.out.println("if locka");
                synchronized (MyLock.lockb){
                    System.out.println("else lockb");
                }
            }
            }
        }
        else{
            while(true) {
                synchronized (MyLock.lockb) {
                    System.out.println("if lockb");
                    synchronized (MyLock.locka) {
                        System.out.println("else locka");
                    }
                }
            }
        }
    }
}

class MyLock{
    static Object locka = new Object();
    static Object lockb  = new Object();
}
public class DeadLockTest {
    public static void main(String[] args){
        Thread t1 = new Thread(new Test1(true));
        Thread t2 = new Thread(new Test1(false));
        t1.start();
        t2.start();
    }
}
