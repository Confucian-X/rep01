package com.itheima.demo13lock;

/*
    创建3个线程进行买相同的100张票
 */
public class Demo01PayTticket {
    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t0.start();
        t1.start();
        t2.start();
    }
}
