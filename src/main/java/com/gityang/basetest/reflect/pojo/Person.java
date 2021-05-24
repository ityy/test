package com.gityang.basetest.reflect.pojo;

/**
 * 供反射测试使用的一个pojo类
 * 包含一些属性和方法
 */
public class Person {
    //公开属性
    public String name;
    //私有属性
    private char sex;
    private int age;

    //定义静态代码块 仅在内加载到内存时执行 不管以后创建几个对象都不再执行
    static {
        System.out.println("Person类 已加载到内存中!");
    }

    //无参构造
    public Person() {

    }

    //有参构造
    public Person(String name) {
        this.name=name;
    }

    //用于对反射方法的测试
    public void showInfo1() {
        System.out.println("执行了方法: public void showInfo1() ");
    }

    private int showInfo2() {
        System.out.println("执行了方法: private int showInfo2() ");
        return 520;
    }

    private int showInfo3(int a, int b) {
        System.out.println("执行了方法: private int showInfo3(int a, int b) ");
        return a + b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
