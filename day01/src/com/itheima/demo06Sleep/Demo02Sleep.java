package com.itheima.demo06Sleep;

public class Demo02Sleep {
    public static void main(String[] args) {
        //秒表
        for (int i = 1; i <= 60; i++) {
            System.out.println(i);
            //睡眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
