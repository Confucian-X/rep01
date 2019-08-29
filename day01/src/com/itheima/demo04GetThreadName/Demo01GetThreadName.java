package com.itheima.demo04GetThreadName;

/*
    线程的名称:
        主线程:main
        新的线程:Thread-0,Thread-1,Thread-2
 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
        //创建子类对象
        MyThread mt = new MyThread();
        //调用Thread类中的start方法,开启新的线程执行run方法
        mt.start();

        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        System.out.println(Thread.currentThread().getName());
    }
}
