package com.itheima.demo03Thread;

//1.创建一个类继承Thread类
public class MyThread extends Thread{
    //2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(开启新的线程做什么事情?)
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run-->"+i);
        }
    }
}
