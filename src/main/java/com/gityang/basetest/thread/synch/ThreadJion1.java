package com.gityang.basetest.thread.synch;

/**
 * 功能：
 * 用类Npp的方法使主类的静态变量n从0加到100
 * 让类Npp的方法并发执行100个
 *
 * 本段程序：
 * Npp采用继承Thread类
 * 线程数组采用new 100个Npp对象
 *
 * 结果：
 * 不正确
 *
 * 改正方法：
 * 让同步方法变成静态的
 *
 */
public class ThreadJion1 {
    // 100个线程要操作的静态变量
    public static int n;

    public static void main(String[] args) throws InterruptedException {
        Thread[] th = new Thread[100];
        for (int i = 0; i < 100; i++) {
            th[i] = new Npp1();
            th[i].start();
            // th[i].join(); //join表示等待此线程结束再继续向下执行，放在这里相当于100个线程顺序执行，而非并发执行
        }

        for (int i = 0; i < 100; i++)
            th[i].join();// 等待100个线程并发执行结束

        System.out.print(Npp1.n);

    }

}

   class Npp1 extends Thread {
    // 100个线程要操作的静态变量
    public static int n;

    public  void run() {

        nadd();

        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }

    }

    // 同步方法，但打印结果不是10000，因为同步锁是this，而new了100个对象导致锁不一样
    // 加上Static描述后，结果为10000
    // 因为这样会使此方法静态，那么100个对象锁就都一样了
//    synchronized static void nadd() {
    synchronized  void nadd() {
        for (int i = 0; i < 2000; i++, n++)
            ;

    }
}
