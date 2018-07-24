package cn.yang.basetest.reflect;

import cn.yang.basetest.reflect.pojo.Person;

import java.lang.reflect.Method;

/**
 * 通过反射获取某个类的方法
 * 测试Class类对象的方法
 * 测试Method类对象的方法
 */
public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        //获取Class类对象
        Class class1=Person.class;

        //反射方法
        //参数1 方法名, 参数2 参数序列 类型为.class
        Method personMethodshowInfo1 = class1.getMethod("showInfo1", null);
        Method personMethodshowInfo3 = class1.getDeclaredMethod("showInfo3", int.class, int.class);



    }
}
