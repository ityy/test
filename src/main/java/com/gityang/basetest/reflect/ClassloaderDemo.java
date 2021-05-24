package com.gityang.basetest.reflect;

import com.gityang.basetest.reflect.pojo.Person;

/**
 * 测试类加载器
 */
public class ClassloaderDemo {
    public static void main(String[] args) {

        //获得Demo字节码文件的类加载器
        Class class1 = Person.class;//获得Demo的字节码对象
        ClassLoader classLoader = class1.getClassLoader();//获得类加载器
        //获得classes(src)下的任何的资源 getResource的参数路径相对classes（src）
        String path = classLoader.getResource("properties/db.properties").getPath();
        System.out.println(path);
        /*
            输出结果:
            /D:/temp/maven_target/Test/target/classes/properties/db.properties
            因为我改了maven的target的输出目录. 为了onedrive不同步target, 所以改了目录
         */


        //classLoader.getResourceAsStream("");

    }
}
