package cn.yang.test.io;

import java.io.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 缓冲区的出现是为了提高流的操作效率而出现的。
 * 所以在创建缓冲区之前，必须要先有流对象。
 * 缓冲区中提供了一个跨平台的换行符 newline()
 */
class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建一个字符写入流对象。
        FileWriter fw = new FileWriter("buf.txt");

        //为了提高字符写入流效率。加入缓冲技术。
        //只要将需要被提高效率的流对象作为参数传递给需要操作的流对象即可
        //缓冲区类的原理属于【功能增强】，基础操作还是基于参数内的类 这里是fw
        BufferedWriter bufw = new BufferedWriter(fw);

        bufw.write("abcde");

        //只要用到缓冲区，一定记得要刷新，否则数据只在缓冲区(内存)而不在存储器(硬盘)
        bufw.flush();

        //缓冲区关闭就是关闭fw
        bufw.close();
    }
}