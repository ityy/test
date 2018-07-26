package cn.yang.basetest.reflectproxy;

/**
 * 供背代理对象实现的接口
 * 这样就可以通过这个接口来调用对象的方法 对多态的利用
 */
public interface TargetInterface {
    public void method1();

    public String method2();

    public int method3(int x);
}
