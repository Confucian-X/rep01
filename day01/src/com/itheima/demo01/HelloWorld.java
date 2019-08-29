package com.itheima.demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

/*
    快捷键:
        主方法; psvm
        输出语句: sout
        向下复制一行:ctrl+d
        删除一行:ctrl+y
        上下移动行:ctrl+shift+↑↓
        添加注释:
            单行注释:添加,删除
                ctrl+/
            多行注释:添加,删除
                ctrl+shift+/
         导包:alt+Enter
         处理异常:alt+Enter
         创建包,类:alt+insert
         添加get/set方法,构造方法,toString方法,equals and hashCode方法:alt+insert
    运行:
        右键==>run运行
 */
public class HelloWorld {
    public static void main(String[] args) throws FileNotFoundException {
        /*System.out.println("HelloWorld1");
        System.out.println("HelloWorld2");*/
        Random r = new Random();
        InputStream is = new FileInputStream("a.txt");
    }
}
