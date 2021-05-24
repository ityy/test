package com.gityang.basetest.reflect;

import com.gityang.basetest.reflect.pojo.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过反射获取某个类的字段
 * 测试Class类对象的方法
 * 测试Field类对象的方法
 */
public class FieldDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        //获取Class类对象
        Class class1 = Person.class;
        /*
            反射字段的4个方法:
                Field  class1.getField(String name); //根据字段名获取字段 仅限公开权限
                Field[] class1.getFields();  //获取所有字段 仅限公开权限
                Field class1.getDeclaredField(String name);  //根据字段名获取字段 无视访问权限
                Field class1.getDeclaredFields(); //获取所有字段 无视访问权限
         */
        //获取字段类Field的对象
        Field personFieldName = class1.getField("name");
        System.out.println(personFieldName); //打印了 包名.类名.字段名 这样的全名
        System.out.println(personFieldName.getName()); //打印了字段名


        /*
            通过反射 获取类的所有信息 完整版
            用字符串拼接的方式让其按源码那样显示出来
         */
        System.out.println("********类的反编译**********");
        StringBuilder sb = new StringBuilder();
        //获取类的修饰符
        int modifiers = class1.getModifiers(); //此方法返回修饰符 整数型是为了方便对比判断 如需名称需用Modifier解析
        sb.append(Modifier.toString(modifiers) + " class "); //将int解析为修饰符的名称
        //获取类名
        sb.append(class1.getSimpleName()); //获取简单类名 就是不带包名的意思
        //获得父类
        Class superClass = class1.getSuperclass();
        if (superClass != Object.class) {
            sb.append(" extends " + superClass.getName());
        }
        //获得接口
        Class[] interfaces = class1.getInterfaces();
        if (interfaces.length > 0) {
            sb.append(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                if (i >= interfaces.length - 1) {
                    sb.append(interfaces[i].getSimpleName());
                } else {
                    sb.append(interfaces[i].getSimpleName() + ",");
                }
            }
        }
        sb.append(" {\n");

        //获取字段
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            //字段的修饰符
            sb.append("    " + Modifier.toString(field.getModifiers()) + " ");
            //字段的类型
            sb.append(field.getType().getSimpleName() + " ");
            //字段名
            sb.append(field.getName() + ";\n");
        }
        sb.append("\n");

        //获取方法
        Method[] methods = class1.getDeclaredMethods();
        for (Method method : methods) {
            //方法的修饰符
            sb.append("    " + Modifier.toString(method.getModifiers()) + " ");
            //方法的返回值类型
            sb.append(method.getReturnType().getSimpleName() + " ");
            //方法的名字
            sb.append(method.getName() + " (");
            //方法的参数
            Class<?>[] parameterTypes = method.getParameterTypes(); //获取所有的参数类型
            for (int i = 0; i < parameterTypes.length; i++) { //遍历
                if (i >= parameterTypes.length - 1) {
                    sb.append(parameterTypes[i].getSimpleName()); //打印简单的类型名
                } else {
                    sb.append(parameterTypes[i].getSimpleName() + ",");
                }
            }

            sb.append(");\n");

        }

        //结尾
        sb.append("}");
        System.out.println(sb.toString());
        System.out.println("**************************");
    }
}
