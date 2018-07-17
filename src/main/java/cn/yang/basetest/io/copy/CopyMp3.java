package cn.yang.basetest.io.copy;

/**
 * 字节流的缓冲区
 * 演示MP3的复制，通过缓冲区。
 * BufferedOutputStream
 * BufferedInputStream
 */

import java.io.*;

class CopyMp3 {
    public static void main(String[] args) throws IOException {
        //end-start的作用是为了表达 copy_1() 运行所花费的时间
        long start = System.currentTimeMillis();
        copy_1();
        long end = System.currentTimeMillis();

        System.out.println((end - start) + "毫秒");

    }

    //通过字节流的缓冲区完成复制。
    public static void copy_1() throws IOException {
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("c:\\1.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\2.mp3"));

        int by = 0;

        //从bufis缓冲区读一个字节，就往bufos缓冲区里写一个字节
        //BufferedInputStream.read() 实际上从硬盘读取了一定量的数据
        //然后从bufis缓冲区里一次读一个字节 并非一次读硬盘一个字节
        //可参考自定义字节缓冲区
        while ((by = bufis.read()) != -1) {
            bufos.write(by);
        }

        bufis.close();
        bufos.close();
    }

}