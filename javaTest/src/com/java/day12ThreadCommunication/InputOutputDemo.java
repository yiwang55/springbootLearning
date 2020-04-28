package com.java.day12ThreadCommunication;


class Res{
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name,String sex) {
        if (flag )
            try{this.wait();}catch (Exception e){}
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }
    public void out(){
        if (!flag )
            try{this.wait();}catch (Exception e){}
        System.out.println(name+"......"+sex);
        flag = false;
        this.notify();
    }
}
class Input implements Runnable{
    private Res r;
    Input(Res r){
        this.r = r;
    }
    @Override
    public void run() {
        int x = 0;
        while(true){
                if (x == 0)
                    r.set("mike","man");
                 else
                    r.set("丽丽","女女女女女");
            x = (x+1)%2;
        }
    }
}
class Output implements Runnable{
    private Res r;

    Output(Res r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true){
            r.out();
        }
    }
}
public class InputOutputDemo {
    public static void main(String[] args){
        Res r = new Res();

        new Thread(new Input(r)).start();
        new Thread(new Output(r)).start();
        /*
        Input in  = new Input(r);
        Output out = new Output(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();
        */
    }
}
