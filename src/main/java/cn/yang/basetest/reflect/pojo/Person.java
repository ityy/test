package cn.yang.basetest.reflect.pojo;

import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * 供其他类测试使用的一个pojo类
 * 包含一些属性和方法
 */
public class Person {
    //公开属性 反射字段时测试使用
    public String name;
    //私有属性
    private char sex;
    private int age;

    //定义静态代码块 仅在内加载到内存时执行 不管以后创建几个对象都不再执行
    static {
        System.out.println("Person类 已加载到内存中!");
    }

    //用于反射创建实例的构造方法
    //无参
    public Person() {

    }

    //有参
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
