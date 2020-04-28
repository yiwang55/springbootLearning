package com.java.day12ThreadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{
    private String name;
    private int count =1;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition1 = lock.newCondition();

    public  void set(String name) throws InterruptedException
    {

        lock.lock();

        while (flag)
            try {
                condition.await();
                this.name = name + "---" + count++;
                System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
                flag = true;
                condition.signalAll();
            }
            finally{
                lock.unlock();
            }


    }
    public void out()throws InterruptedException
    {
        lock.lock();
        try{
            while (!flag)
                condition.await();
            System.out.println(Thread.currentThread().getName()+"...消费者................."+ this.name);
            flag = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable{
    private Resource res;
    Producer(Resource res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true){
            try{
            res.set("+商品+");
        }catch (InterruptedException e){}
        }
    }
}

class  Consumer implements Runnable{
    private Resource res;
    Consumer(Resource res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true){
            try{
                res.out();
            }catch (InterruptedException e){}
        }
    }
}
public class ProducerConsumerDemo
{
    public static void main(String[] args){
    Resource r = new Resource();
    Producer pro = new Producer(r);
    Consumer con = new Consumer(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
}
}