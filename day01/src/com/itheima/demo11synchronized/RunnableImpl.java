package com.itheima.demo11synchronized;

/*
    卖票案例产生了线程安全问题:
        1.出现了不存在的票
        2.出现了重复的票
    解决线程安全问题的第一种方式:使用同步代码块
        格式:
            synchronized(锁对象){
                访问了共享数据的代码(产生线程安全问题的代码)
            }
        注意:
            锁对象可以是任意的对象new Person  new Object  new Studnet
            必须保证所有的线程使用的是同一个锁对象(唯一)
 */
public class RunnableImpl implements Runnable{
    //定义共享的票源
    private int ticket = 100;
    //定义一个锁对象
    Object obj = new Object();

    //线程任务:卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
            //同步代码块
            synchronized (obj){
                //票大于0,就进行卖票
                if(ticket>0){
                    //让线程睡眠10毫秒,提供安全问题出现的几率
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票!");
                    ticket--;
                }
            }
        }
    }
}
