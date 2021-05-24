package com.gityang.basetest.reflectproxy;

/**
 * 目标对象
 * 即被代理的类 通过这个类生成代理对象
 */
//实现了我们定义的接口
public class Target implements TargetInterface{

    //实现接口中的所有方法
    @Override
    public void method1() {
        System.out.println("method1 running...");
    }
    @Override
    public String method2() {
        System.out.println("method2 running...");
        return "method2的返回值";
    }
    @Override
    public int method3(int x) {
        System.out.println("method3 running...");
        return x;
    }
}
