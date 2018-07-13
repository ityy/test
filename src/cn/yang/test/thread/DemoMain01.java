package cn.yang.test.thread;


public class DemoMain01 {

    public static void main(String[] args) {

        Thread thread = new Thread01();
        thread.start();
        Thread thread1 = new Thread(new Runnable01());
        thread1.start();
        Thread thread2 = new Thread(new Runnable01());
        thread2.start();

    }

}
