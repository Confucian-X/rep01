package com.itheima.demo12synchronized;

/*
    创建3个线程进行买相同的100张票
 */
public class Demo01PayTticket {
    public static void main(String[] args) {
        RunnableImpl r = new RunnableImpl();
        System.out.println("r:"+r);//r:com.itheima.demo12synchronized.RunnableImpl@4554617c
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t0.start();
        t1.start();
        t2.start();
    }
}
