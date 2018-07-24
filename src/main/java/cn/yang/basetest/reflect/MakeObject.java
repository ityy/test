package cn.yang.basetest.reflect;

import cn.yang.basetest.reflect.pojo.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射来创建对象
 * 调用对象的方法
 * 获取对象的字段值
 * 通过其他构造方法来创建对象
 */
public class MakeObject {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取Class类对象
        Class class1=Person.class;

        //创建对象 此方法默认使用无参构造函数来创建
        Object newInstance1 = class1.newInstance();

        /*
            调用对象的方法
         */
        //无参无返回的方法的演示
        //从类那里 获取方法反射 参数1 方法名, 参数2 方法的参数序列
        Method showInfo1 = class1.getDeclaredMethod("showInfo1");
        //让方法反射知道 调用的哪个对象的此方法.  参数1 调用此方法的对象, 参数2 传递的参数
        showInfo1.invoke(newInstance1);

        //有参有返回的方法的演示
        Method showInfo3 = class1.getDeclaredMethod("showInfo3", int.class, int.class);
        //无视访问权限 设置为真  否则私有方法不能访问
        showInfo3.setAccessible(true);
        Object result1 = showInfo3.invoke(newInstance1, 111, 222);
        System.out.println(result1);

        /*
            利用反射操作字段 逻辑步骤和调用对象的方法类似
            但是不推荐这么做, 推荐使用set get方法来操作字段
         */
        //从类那里 获取字段的反射
        Field fieldName = class1.getDeclaredField("name");
        //无视访问权限 设置为真  否则私有字段不能访问
        showInfo3.setAccessible(true);
        //让字段反射知道操作的哪个对象
        fieldName.set(newInstance1,"yang");
        Object result2 = fieldName.get(newInstance1);
        System.out.println(result2);

        //------------------------------------------------------------------------

        /*
            利用不同的构造方法来创建实例
         */
        //获得构造方法的反射 参数为构造方法的参数类型的.class
        Constructor constructor = class1.getConstructor(String.class);
        //利用构造方法创建实例
        Object newInstance2 = constructor.newInstance("liyang");
        System.out.println(newInstance2);
        System.out.println(fieldName.get(newInstance2));

    }

}
