package com.itheima.demo07Runnable;

/*
    创建多线程程序的第二种方式:实现Runnable接口

    java.lang.Runnable接口:
        Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为 run 的无参数方法。
     java.lang.Thread类的构造方法:
        Thread(Runnable target) 分配新的 Thread 对象。
        Thread(Runnable target, String name) 分配新的 Thread 对象。
     实现步骤:
        1.创建一个实现类实现Runnable接口
        2.重写Runnable接口中的run方法,设置线程任务
        3.创建Runnable接口的实现类对象
        4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        5.调用Thread类中的start方法,开启新的线程,执行run方法
 */
public class Demo01Thread {
    public static void main(String[] args) {
        //3.创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        //4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t = new Thread(run);
        //5.调用Thread类中的start方法,开启新的线程,执行run方法
        t.start();

        //main线程继续执行的代码
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
