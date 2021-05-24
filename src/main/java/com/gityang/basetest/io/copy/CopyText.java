package cn.yang.basetest.io.copy;

import org.junit.Test;

import java.io.*;

//文本文件的复制 (读写综合应用)

/*
需求：
    将C盘的一个文本文件复制到D盘
复制的原理：
    其实就是读C盘的文件，写到D盘

步骤：
    1 在D盘创建一个文件，用于存储C盘文件中的数据
    2 定义读取流和C盘文件关联
    3 通过不断的读写完成数据的存储
    4 关闭资源

*/

public class CopyText {

    /**
     * 从C盘读一个字符，就往D盘写一个字符。 实际上，因为硬盘物理结构，这种做法效率低且伤硬盘
     */
    @Test
    public void copy_1() throws IOException {
        // 创建目的地 不指定路径则默认路径为: 当前项目路径
        FileWriter fw = new FileWriter("目的.txt");
        System.out.println("当前项目路径:"+System.getProperty("user.dir"));
        System.out.println("当前类文件(编译后)路径:"+this.getClass().getResource("").getPath());
        // 与要复制的文件关联
        File f = new File(this.getClass().getResource("").getPath() + "\\源.txt");
        FileReader fr = new FileReader(f);

        int ch = 0;

        while ((ch = fr.read()) != -1) {
            fw.write(ch); // 读一个ch，写一个ch
        }

        fw.close();
        fr.close();

    }

    /**
     * 利用字符数组进行缓冲的复制方法
     */
    @Test
    public void copy_2() {
        //创建引用
        FileWriter fw = null;
        FileReader fr = null;

        try {
            //指向对象
            fw = new FileWriter("目的.txt");
            fr = new FileReader("源.txt");

            char[] buf = new char[1024];

            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                }
            }
        }
    }
}