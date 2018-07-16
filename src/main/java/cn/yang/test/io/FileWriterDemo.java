package cn.yang.test.io;
/*
字符流和字节流：

字节流的两个基类：
ImputStream OutputStream

字符流的两个基类：
Reader Writer

先学习一下字符流的特点。
既然IO流是用于操作数据的，而数据的最常见形式是文件。
那么先以操作文件为主来演示。

需求：
    在硬盘上，创建一个文件并写入一些文字数据。

思路：
    根据需求，需要用到IO操作，找到java.io包。
    由写入文字数据找到包内Writer类。
    此类是抽象类，继续找到它的实现子类OutputStreamWriter
    继续找到它的实现子类FileWriter
    此类提供的方法可以解决需求。

*/

import java.io.*;


public class FileWriterDemo
{
    public static void main(String[] args) throws IOException
    {
        //创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
        //创建指定文件，如果已存在则【覆盖】
        FileWriter fw = new FileWriter("demo.txt");

        //调用write方法，将字符串写入到流(内存)中。
        fw.write("abcde");

        //调用flush方法，将数据刷新到存储器(硬盘)中。
        fw.flush();

        //续写
        fw.write("abc333de");
        fw.flush();

        //关闭流资源，关闭之前自动调用flush方法刷新 关闭后不可续写
        fw.close();
    }
}