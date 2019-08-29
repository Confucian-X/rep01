package com.itheima.demo03Thread;

/*
    创建多线程程序的第一种方式(重点):继承Thread类
    java.lang.Thread:描述线程的类,要实现多线程程序,就必须使用Thread类
    实现步骤:
        1.创建一个类继承Thread类
        2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(开启新的线程做什么事情?)
        3.创建Thread类的子类对象
        4.调用Thread类中的start方法,开启一个新的线程,执行run方法

        void start() 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
            结果是两个线程并发地运行；当前线程（主线程:用于执行main方法中的代码）和另一个线程（开启的新线程:执行其 run 方法）。
            多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
            一个Thread对象只能调用一次start方法

    java程序属于抢占式调度,优先让优先级高的线程使用cpu,多个线程的优先级相同,cpu随机选择一个线程执行(程序的随机性)
 */
public class Demo01Thread {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyThread mt = new MyThread();
        //4.调用Thread类中的start方法,开启一个新的线程,执行run方法
        mt.start();

        new MyThread().start();


        //主线程会继续执行main方法中的代码
        for (int i = 0; i < 20; i++) {
            System.out.println("main-->"+i);
        }
    }
}
