package com.itheima.demo09Thread;

/*
    匿名内部类:
        匿名:没有名字
        内部类:写在其他类内部的类(成员,局部)
    作用:简化代码
        把子类继承父类,重写父类中的方法,创建子类对象合成一步完成
        把实现类实现接口,重写接口中的方法,创建实现类对象合成一步完成
    格式:
        new 父类/接口(){
            重写父类/接口中的方法;
        }
    注意:
        匿名内部类最终的产生就是一个子类/实现类对象
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }
        以上代码就相当于new MyThread();
 */
public class Demo01Thread {
    public static void main(String[] args) {
        //父类:Thread
        //new MyThread().start();
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        //接口:Runnable
        //多态:父类的引用指向了子类的对象
        // Runable r = new RunnableImpl();
        //new Thread(r).start();
        //new Thread(new RunnableImpl()).start();
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(r).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
