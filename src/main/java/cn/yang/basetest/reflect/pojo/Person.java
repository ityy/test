package cn.yang.basetest.reflect.pojo;

import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * 供其他类测试使用的一个pojo类
 * 包含一些属性和方法
 */
public class Person {
    //定义属性
    private String name;
    private char sex;
    private int age;

    //定义静态代码块 仅在内加载到内存时执行 不管以后创建几个对象都不再执行
    static {
        System.out.println("Person类 已加载到内存中!");
    }
}
