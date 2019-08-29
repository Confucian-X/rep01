package com.itheima.demo02MainThread;

/*
    主线程:执行主方法(main方法)的线程

    单线程程序:
        程序从main方法开始,自上到下依次执行
 */
public class Demo01MainThread {
    public static void main(String[] args) {
        Person p1 = new Person("张三");
        p1.run();

        Person p2 = new Person("李四");
        p2.run();
    }
}
