package com.gityang.basetest.io;

import java.io.*;

/**
 * 基础用法
 */
public class  FileReaderDemo
{
    public static void main(String[] args) throws IOException
    {
        //创建一个文件读取流对象，和指定名称的文件相关联。
        //要保证该文件存在，否则异常。
        FileReader fr = new FileReader("demo.txt");

        //调用read方法 读入一个字符
        //read() ： 一次读一个字符，而且会自动往下读，如果已到达流的末尾，则返回 -1
        int ch = fr.read();
        System.out.println("ch="+(char)ch);

        //利用循环，读入多个字符
        int ch2 = 0;
        while ((ch2=fr.read()) != -1)  //如果为-1则表示读完了
        {
            System.out.println("ch="+(char)ch2);
        }
        fr.close();

        /*
         *第二种方式：通过字符数组进行读取。
         *int read(char[] cbuf)
         *    将字符读入数组。
         *    返回读取的字符数，每次读都会把前一次的cbuf覆盖，到数据末尾时，
         *    则读多少覆盖多少，由返回的读到的字符数来判断最后一次读了多少字符。
         *
         *int read(char[] cbuf, int offset, int length)
         *    将字符读入数组中的某一部分。
         *
         */

        FileReader fr2 = new FileReader("demo.txt");

        char[] buf = new char[1024];
        int num = 0;

        //一次最大读一个数组的长度 返回本次读取到的长度 读完返回-1
        while ((num=fr2.read(buf)) != -1) //文件读完则结束循环
        {
            System.out.print(new String(buf,0,num));//num为每次读到的长度
        }

    }
}
