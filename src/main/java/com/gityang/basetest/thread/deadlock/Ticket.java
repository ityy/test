package com.gityang.basetest.thread.deadlock;

/**
死锁。
同步中嵌套同步。
*/
public class Ticket implements Runnable {
    private int tick = 1000;
    Object obj = new Object();
    boolean flag = true;

    public void run() {
        if (flag) {
            while (true) {
                // 代码块已经定义锁是obj
                synchronized (obj) {
                    // 拿到obj锁
                    // 本线程已经拿到obj锁，本线程的show()里也相当于拿到
                    // 只有另一个线程拿到锁，本线程才会等待
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                    // 拿到obj，在等this
                    show();
                    // 释放obj锁
                }
            }
        } else
            while (true)
                show();
    }

    // show()方法的锁是this
    public synchronized void show()// this
    {
        if (tick > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
            // 拿到this锁，在等obj
            synchronized (obj) {
                // 拿到obj锁

                System.out.println(Thread.currentThread().getName() + "....code : " + tick--);
            }
            // 释放obj锁
        }
        // 释放this锁
    }
}

class DeadLockDemo {
    public static void main(String[] args) {

        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
        t.flag = false;
        t2.start();

    }
}
