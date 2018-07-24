package cn.yang.basetest.reflect;

import cn.yang.basetest.reflect.pojo.Person;

/**
 * 测试类 Class
 * 获取类Class的对象
 *
 * @author yanga
 * @date 2018年7月24日
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            获取类Class的对象有三种方式
         */
        //方式1 使用每个类都有的class属性获取 没有加载到内存中
        Class class1 = Person.class;
        System.out.println("class1:" + class1);

        //方式2 使用静态方法forName("完整类名")获取 会加载到内存中
        Class class2 = Class.forName("cn.yang.basetest.reflect.pojo.Person");
        System.out.println("class2:" + class2);
        System.out.println("class1是否等于class2: " + (class1 == class2));

        //方式3 使用每个对象都有的getClass方法获取运行时类
        Person person = new Person(); // 也可将类加载到内容中 但是如果之前已经加载过一次 则不会再加载
        Class class3 = person.getClass();
        System.out.println("class1是否等于class3: " + (class1 == class3));

        /*
            对基本数据类型和包装类型的测试
         */
        Class class4 = int.class;
        Class class5 = Integer.TYPE;  //返回所对应的基本类型的类对象
        Class class6 = Integer.class;
        System.out.println("class4:" + class4 + ", class5:" + class5 + ", class6:" + class6);
        System.out.println("class4是否等于class5: " + (class4 == class5));
        System.out.println("class4是否等于class6: " + (class4 == class6));

    }

}
