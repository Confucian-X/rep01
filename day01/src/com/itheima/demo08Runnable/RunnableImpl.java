package com.itheima.demo08Runnable;

//1.创建一个实现类实现Runnable接口
public class RunnableImpl implements Runnable{
    //2.重写Runnable接口中的run方法,设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
