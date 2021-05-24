package com.gityang.basetest.io;

import java.io.*;

//自定义字节流输入缓冲区
public  class MyBufferedInputStream {
    private InputStream in;
    private byte[] buf = new byte[1024]; //缓冲区
    private int pos = 0, count = 0; //指针，计数器

    //传入输入字节流对象
    MyBufferedInputStream(InputStream in) {
        this.in = in;
    }

    //一次读一个缓冲区字节，从硬盘获取
    //一次读一个字节，从缓冲区(字节数组)获取。
    public int myRead() throws IOException {
        //通过in对象读取硬盘上数据，并存储到buf中 用count记录个数
        if (count == 0) //缓冲区为0时，从硬盘读入缓冲区
        {
            count = in.read(buf);
            pos = 0;
            byte b = buf[pos];

            count--;
            pos++;

            /*
             *为什么要&255?
             *当只返回b的时候，如果读取的字节数据形如11111111 转换为int后变为
             *11111111 11111111 11111111 11111111(即十进制-1)
             *将导致数据没读完便提前结束了。
             *而&255 就是和 00000000 00000000 00000000 11111111 相与
             *则必返回后8位有效数据 而不会再返回十进制的-1
             *不必担心写入时1字节会变成4字节，write方法只取后8位数据。
             *实践验证通过
             */
            return b & 255;

        } else if (count > 0) //缓冲区不为0时 从缓冲区读入
        {
            byte b = buf[pos];

            count--;
            pos++;
            return b & 0xff; //等效于b&255
        }

        //返回11111111 11111111 11111111 11111111(即十进制-1)
        return -1;
    }

    public void myClose() throws IOException {
        in.close();
    }
}

//利用复制mp3程序 检查自定义字节流缓冲区
class MyBufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //end-start的作用是为了表达 copy_1() 运行所花费的时间
        long start = System.currentTimeMillis();
        copy_1();
        long end = System.currentTimeMillis();

        System.out.println((end - start) + "毫秒");
    }

    //通过自定义字节流的缓冲区完成复制。
    public static void copy_1() throws IOException {
        MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("c:\\1.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\2.mp3"));

        int by = 0;

        //从bufis缓冲区读一个字节，就往bufos缓冲区里写一个字节
        //BufferedInputStream.read() 实际上从硬盘读取了一定量的数据
        //然后从bufis缓冲区里一次读一个字节 并非一次读硬盘一个字节
        //可参考自定义字节缓冲区
        while ((by = bufis.myRead()) != -1) {
            bufos.write(by);
        }

        bufis.myClose();
        bufos.close();
    }
}
