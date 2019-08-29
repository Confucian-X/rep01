package com.itheima.demo12synchronized;

/*
    卖票案例产生了线程安全问题:
        1.出现了不存在的票
        2.出现了重复的票
    解决线程安全问题的第二种方式:使用同步方法
    实现步骤:
        把产生线程安全问题的代码提取出来,放到一个方法中
        给方法添加一个同步(synchronized)的修饰符
 */
public class RunnableImpl implements Runnable{
    //定义共享的票源
    private static int ticket = 100;

    //线程任务:卖票
    @Override
    public void run() {
        System.out.println("this:"+this);//this:com.itheima.demo12synchronized.RunnableImpl@4554617c
        //让卖票重复执行
        while (true){
            payTicket3();
        }
    }

    /*
        了解:静态的同步方法
        锁对象是谁?
            是this吗,不是,静态方法优先于this加载到内存中
            是本类的class文件对象:RunnableImpl.class(反射)
     */
    public static /*synchronized*/ void payTicket3(){
        synchronized (RunnableImpl.class){
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


    public  void payTicket2(){
        synchronized (this){
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

    /*
        定义同步方法
        原理:
            使用一个同步方法把产生线程安全问题的代码包裹起来
            只让一个线程获取锁对象,进入到同步方法中执行
        同步方法的锁对象是谁?
            是this,本类对象的引用
            RunnableImpl
     */
    public synchronized void payTicket(){
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
