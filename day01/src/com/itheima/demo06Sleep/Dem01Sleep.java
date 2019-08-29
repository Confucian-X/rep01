package com.itheima.demo06Sleep;

/*
    static void sleep(long millis)
          在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）， 睡醒了继续执行
 */
public class Dem01Sleep {
    public static void main(String[] args) {
        //让程序睡眠10秒
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("10秒钟之后执行");
    }
}
