package cn.yang.test.io;

/**
 * 字节流：
 * InputStream
 * OutputStream
 *
 * FileInputStream
 * FileOutputStream
 *
 * 需求：
 * 想要操作图片数据，这时就要用到字节流
 */

import java.io.*;

class FileStream {
    public static void main(String[] args) throws IOException {
        writeFile();
        readFile_1();
        readFile_2();
        readFile_3();

    }

    public static void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");

        fos.write("abcde".getBytes()); //字节流不需要刷新，因为没有用缓存机制

        fos.close();
    }

    //一个字节一个字节读
    public static void readFile_1() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        int ch = 0;
        while ((ch = fis.read()) != -1) {
            System.out.println((char) ch);
        }
        fis.close();
    }

    //用字节数组作缓冲
    public static void readFile_2() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");
        byte[] buf = new byte[1024]; //用byte数组是因为read()的参数要求
        int len = 0;

        //一次读1024个字节，循环到读完
        while ((len = fis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }

        fis.close();
    }

    //利用available() 获得剩余字节数
    public static void readFile_3() throws IOException {
        FileInputStream fis = new FileInputStream("fos.txt");

        //定义一个刚刚好的数组，作缓冲区
        byte[] buf = new byte[fis.available()];

        fis.read(buf);
        System.out.println(new String(buf));
        fis.close();

    }

}