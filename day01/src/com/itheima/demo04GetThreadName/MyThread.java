package com.itheima.demo04GetThreadName;

/*
    获取线程的名称:
        1.使用Thread类中的方法getName
            String getName() 返回该线程的名称。
        2.先获取到当前正在执行的线程Thread,在通过Thread类中的方法getName获取到线程的名称
            static Thread currentThread()返回对当前正在执行的线程对象的引用。
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        //1.使用Thread类中的方法getName
        //String name = getName();
        //System.out.println(name);

        //2.先获取到当前正在执行的线程Thread,在通过Thread类中的方法getName获取到线程的名称
        /*Thread currentThread = Thread.currentThread();
        System.out.println(currentThread);// Thread[Thread-0,5,main] 重写了toString方法
        String name = currentThread.getName();
        System.out.println(name);*/

        //链式编程
        System.out.println(Thread.currentThread().getName());
    }
}
