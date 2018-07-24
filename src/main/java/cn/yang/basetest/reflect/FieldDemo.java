package cn.yang.basetest.reflect;

import cn.yang.basetest.reflect.pojo.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 通过反射获取某个类的字段
 * 测试Class类对象的方法
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
            通过反射 获取类的所有信息
            用字符串拼接的方式让其按源码那样显示出来
         */
        System.out.println("********类的反编译**********");
        StringBuilder sb = new StringBuilder();
        //获取类的修饰符
        int modifiers = class1.getModifiers(); //此方法返回修饰符 整数型是为了方便对比判断 如需名称需用Modifier解析
        sb.append(Modifier.toString(modifiers) + " class "); //将int解析为修饰符的名称
        //获取类名
        sb.append(class1.getSimpleName() + " {\n"); //获取简单类名 就是不带包名的意思
        //获取字段名
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            //字段的修饰符
            sb.append("    " + Modifier.toString(field.getModifiers()) + " ");
            //字段的类型
            sb.append(field.getType().getSimpleName() + " ");
            //字段名
            sb.append(field.getName() + ";\n");
        }
        sb.append("}");
        System.out.println(sb.toString());
        System.out.println("**************************");
    }
}
