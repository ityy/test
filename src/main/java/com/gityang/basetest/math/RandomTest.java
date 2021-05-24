package com.gityang.basetest.math;

import org.junit.Test;

import java.util.Random;

public class RandomTest {

    /**
     * Math.random()方法的演示
     * Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值，是Java语言常用代码。
     * 例如：double a=Math.random()*(3-1)+1，设置一个随机1到3的变量。即随机0-2, 加上1就是随机1-3了
     * 技巧:随机到任何范围x-y (x<y),  先让x归零, y=y-x, 再统一加上x
     * 还可以做概率来使用
     */
    @Test
    public void demo1() {
        //演示 产生一个[0，1)之间的double型随机数
        System.out.println(Math.random() + "");

        //产生一个1-100之间的随机数
        /*
            向上取整:Math.ceil()   //只要有小数都+1
            向下取整:Math.floor()   //不取小数
            四舍五入:Math.round()  //四舍五入
         */
        System.out.println(Math.round(Math.random() * 99 + 1) + "");

        //当作概率使用 一半的概率显示yangyang和dawang
        if (Math.random() < 0.5) {
            System.out.println("yangyang");
        } else {
            System.out.println("dawang");
        }

    }

    /**
     * Random类的演示
     */
    @Test
    public void demo2() {
        Random r = new Random();

        //返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt());
        }

        //返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 boolean 值。
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextBoolean());
        }

        //返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 int 值。
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(20));
        }

    }
}
