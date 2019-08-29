package com.itheima.demo14TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    创建TCP通信的客户端:
        向服务器发送连接请求和服务器经过3次握手连接逻辑连接;给服务器发送数据,接收服务器回写的数据
    表示客户端的类:
        java.net.Socket:此类实现客户端套接字（也可以就叫“套接字”）。
        套接字:封装了IP地址和端口号的网络单位
    构造方法:
        Socket(String host, int port) 创建一个流套接字并将其连接到指定主机上的指定端口号。
        参数:
            String host:服务器的IP地址
            int port:服务器的端口号
    成员方法:
        OutputStream getOutputStream()返回此套接字的输出流。
        InputStream getInputStream() 返回此套接字的输入流。
        注意:
            客户端和服务器之间进行数据交互,不能使用自己创建的IO流对象,必须使用Socket中提供的网络流
    实现步骤:
        1.创建客户端Socket对象,封装服务器的IP地址和端口号
        2.使用Socket对象中的方法getOutputStream获取网络字节输出流对象
        3.使用OutputStream获取网络字节输出流对象中的方法write,给客户端发送数据
        4.使用Socket对象中的方法getInputStream获取网络字节输入流对象
        5.使用InputStream获取网络字节输入流对象中的方法read,读取服务器回写的数据
        6.释放资源(Socket)

    创建Socket对象,客户端就会和服务器进行三次握手,建立连接
        服务器已经启动:连接建立成功,就可以通行了
        服务器没有启动:会抛出连接异常 ConnectException: Connection refused: connect
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建客户端Socket对象,封装服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1",8888);
        //2.使用Socket对象中的方法getOutputStream获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();
        //3.使用OutputStream获取网络字节输出流对象中的方法write,给客户端发送数据
        os.write("你好服务器".getBytes());
        //4.使用Socket对象中的方法getInputStream获取网络字节输入流对象
        InputStream is = socket.getInputStream();
        //5.使用InputStream获取网络字节输入流对象中的方法read,读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6.释放资源(Socket)
        socket.close();
    }
}
