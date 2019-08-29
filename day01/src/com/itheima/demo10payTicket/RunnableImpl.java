package com.itheima.demo10payTicket;

/*
    卖票案例
 */
public class RunnableImpl implements Runnable{
    //定义共享的票源
    private int ticket = 100;

    //线程任务:卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
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
