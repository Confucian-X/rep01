package com.itheima.demo13lock;

import java.util.concurrent.locks.ReentrantLock;

/*
     卖票案例产生了线程安全问题:
        1.出现了不存在的票
        2.出现了重复的票
    解决线程安全问题的第三方式:使用Lock锁(了解)
    java.util.concurrent.locks.Lock接口
        Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。
        接口中的方法:
            void lock() 获取锁。
            void unlock() 释放锁。
    java.util.concurrent.locks.ReentrantLock implements Lock接口
    实现步骤:
        1.在成员位置创建Lock接口的实现类对象
        2.在可能出现线程安全问题的代码前,使用lock方法获取锁对象
        3.在可能出现线程安全问题的代码后,使用unlock方法释放锁对象
 */
public class RunnableImpl implements Runnable{
    //定义共享的票源
    private int ticket = 100;
    //1.在成员位置创建Lock接口的实现类对象
    private ReentrantLock rl = new ReentrantLock();

    //线程任务:卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
            //2.在可能出现线程安全问题的代码前,使用lock方法获取锁对象
            rl.lock();
            //票大于0,就进行卖票
            if(ticket>0){
                try {
                    //让线程睡眠10毫秒,提供安全问题出现的几率
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票!");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //3.在可能出现线程安全问题的代码后,使用unlock方法释放锁对象
                    rl.unlock();
                }
            }
        }
    }


    /*@Override
    public void run() {
        //让卖票重复执行
        while (true){
            //2.在可能出现线程安全问题的代码前,使用lock方法获取锁对象
            rl.lock();

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

            //3.在可能出现线程安全问题的代码后,使用unlock方法释放锁对象
            rl.unlock();
        }
    }*/
}
