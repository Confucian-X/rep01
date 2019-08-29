package com.itheima.demo14TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
     创建TCP通信的服务器端:
        和客户端经过3次握手连接逻辑连接;接收客户端发送的数据,给客户端回写一个数据
     表示服务器的类:
        jva.net.ServerSocket:此类实现服务器套接字。
     构造方法:
        ServerSocket(int port) 创建绑定到特定端口的服务器套接字。
     成员方法:
        Socket accept() 侦听并接受到此套接字的连接。
        启动服务器之后,有客户端请求服务器,就可以使用accept方法,监听并获取到请求的客户端Socket对象
     实现步骤:
        1.创建服务器ServerSocket对象,和系统要指定的端口号
        2.使用accpet方法,监听并获取请求的客户端对象Socket
        3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        4.使用网络字节输入流InputStream对象中的方法read,读取客户端发送的数据
        5.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
        6.使用网络字节输出流OutputStream对象中的方法write,给客户端回写数据
        7.释放资源(Socket,ServerSocket)
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1.创建服务器ServerSocket对象,和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //2.使用accpet方法,监听并获取请求的客户端对象Socket
        Socket socket = server.accept();
        //3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //4.使用网络字节输入流InputStream对象中的方法read,读取客户端发送的数据
        byte[]  bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //5.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
        OutputStream os = socket.getOutputStream();
        //6.使用网络字节输出流OutputStream对象中的方法write,给客户端回写数据
        os.write("收到,谢谢".getBytes());
        //7.释放资源(Socket,ServerSocket)
        socket.close();
        server.close();
    }
}
