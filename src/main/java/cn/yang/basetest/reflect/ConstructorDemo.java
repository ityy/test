package cn.yang.basetest.reflect;

import cn.yang.basetest.reflect.pojo.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 通过反射获取某个类的构造方法
 * 测试Class类对象的方法
 * 测试Constructor类对象的方法
 */
public class ConstructorDemo {

    public static void main(String[] args) {

        //获取Class类对象
        Class class1 = String.class;

        //反射所有的构造方法
        Constructor[] declaredConstructors = class1.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            //修饰符
            System.out.print(Modifier.toString(constructor.getModifiers()) + " ");
            //方法名 这里用类名代替了
            System.out.print(class1.getSimpleName() + " (");
            //参数序列
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i >= parameterTypes.length - 1) {
                    System.out.print(parameterTypes[i].getSimpleName());
                } else {
                    System.out.print(parameterTypes[i].getSimpleName()+",");

                }
            }
            System.out.print(");\n");

        }
    }
}
