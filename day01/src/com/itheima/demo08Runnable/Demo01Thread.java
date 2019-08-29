package com.itheima.demo08Runnable;

/*
    实现Runnable接口方式和继承Thread类的方式区别:
        1.单继承的局限性
            使用继承Thread类的方式:存在单继承的局限性,一个类只能继承一个类;继承Thread类,就不能继承其他的类
            使用实现Runnable接口的方法:可以继承其他的类
        2.实现Runnable接口把设置线程任务和开启线程继续了解耦,增强了扩展性
            实现Runnable接口,目的就是重写run方法设置线程任务
            创建Thread对象,目的传递Runnable接口的实现类对象(线程任务),执行线程任务
 */
public class Demo01Thread {
    public static void main(String[] args) {
        //3.创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        //4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        //new Thread(run).start(); //执行打印线程名称20次的任务
        new Thread(new RunnableImpl2()).start();//执行打印20次Hello任务
        //main线程继续执行的代码
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
