package cn.yang.basetest.thread.synch;



/*
 * 功能：
 * 用类Npp的方法使主类的静态变量n从0加到100
 * 让类Npp的方法并发执行100个
 *
 * 本段程序：
 * Npp采用实现Runnable接口
 * 线程数组采用new 100个Thread对象，而其参数是同一个Npp对象
 *
 * 结果：
 * 正确

 *
 */
public class ThreadJion2 {

    public static void main(String[] args) throws InterruptedException {
        Npp2 np = new Npp2();
        Thread[] th = new Thread[100];
        for (int i = 0; i < 100; i++) {
            th[i] = new Thread(np);
            th[i].start();
            // th[i].join(); //join表示等待此线程结束再继续向下执行，放在这里相当于100个线程顺序执行，而非并发执行
        }

        for (int i = 0; i < 100; i++)
            th[i].join();// 等待100个线程并发执行结束

        System.out.print(Npp2.n);

    }

}

class Npp2 implements Runnable {
    // 100个线程要操作的静态变量
    public static int n;

    public void run() {

        nadd();

        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }
    }

    // 同步方法，结果正确
    // 因为线程启动的都是这一个对象
    synchronized void nadd() {
        for (int i = 0; i < 2000; i++, n++)
            ;

    }
}

