package com.gityang.basetest.throwable.exception;

public class FinallyDemo {
    public static void main(String[] args) {

        FinallyDemo finallyDemo = new FinallyDemo();
        System.out.println("主程序中: " + finallyDemo.returnTest(100));
        /*
            finally中: 200
            主程序中: 100
            因为finally始终会执行, 所以try中返回了100, 但finally中还是会执行
            可以理解为try中是个快照
         */

    }

    public int returnTest(int a) {
        try {
            return a;
        } catch (Exception e) {

        } finally {
            a = a + a;
            System.out.println("finally中: " + a);
        }
        return 0;
    }
}
