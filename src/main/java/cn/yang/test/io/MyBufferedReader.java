package cn.yang.test.io;

import java.io.*;

/**
 * 利用【装饰设计模式】，来模拟一个BufferedReader
 * 明白了BufferedReader类中特有方法readLine的原理后，
 * 可以自定义一个类中包含一个功能和readLine一致的方法。
 */
public class MyBufferedReader {
    //利用构造函数，将外部FileReader传进来
    private FileReader r;

    MyBufferedReader(FileReader r) {
        this.r = r;
    }

    //可以一次读一行数据的方法
    public String myReadLine() throws IOException {
        //定义一个临时容器，例如字符数组。
        //为了演示方便。定义一个StringBuilder。
        StringBuilder sb = new StringBuilder();
        int ch = 0;

        //每次读一个字符 读入临时容器sb 直到读完一行
        while ((ch = r.read()) != -1) {
            if (ch == '\r')
                continue;
            if (ch == '\n')
                return sb.toString();
            else
                sb.append((char) ch);
        }

        //最后一行结尾没\n时 一样可以返回
        if (sb.length() != 0) {
            return sb.toString();
        }

        return null;
    }

    //调用缓冲区的关闭，其实就是调用“被装饰的类”的关闭功能
    public void myClose() throws IOException {
        r.close();
    }

}

class MyBufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("buf.txt");

        MyBufferedReader myBuf = new MyBufferedReader(fr);

        String line = null;

        while ((line = myBuf.myReadLine()) != null) {
            System.out.println(line);
        }
        myBuf.myClose();

    }
}