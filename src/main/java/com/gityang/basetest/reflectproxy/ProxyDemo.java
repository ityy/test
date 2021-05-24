package cn.yang.basetest.reflectproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *      在运行时的内存中动态生成代理对象。------字节码对象级别的代理对象
 *      （不用像装饰设计模式那样，手动编写一个代理对象还要编写每个与目标对象相同的方法）
 *
 * 在jdk的API中存在一个Proxy中存在一个生成动态代理的的方法newProxyInstance
 * 返回值：Object就是代理对象
 * 参数：loader：代表与目标对象相同的类加载器-------目标对象.getClass().getClassLoader()
 *      interfaces：代表与目标对象实现的所有的接口字节码对象数组
 *      h：具体的代理的操作，InvocationHandler接口
 * 注意：JDK的Proxy方式实现的动态代理 目标对象必须有接口 没有接口不能实现jdk版动态代理
 *
 * 典型应用:数据库的事务处理  日志系统的日志记录
 */
public class ProxyDemo {

    @Test
    public void test1() {

        // targetProxy是代理对象, 通过静态方法newProxyInstance来创建
        TargetInterface targetProxy = (TargetInterface) Proxy.newProxyInstance(
                Target.class.getClassLoader(), // 参数1，与目标对象相同的类加载器
                Target.class.getInterfaces(), // 参数2，目标对象实现的接口，因为可能有多个所以是数组
                /*
                 * 参数3，是一个实现InvocationHandler接口的对象，主要逻辑都在这
                 *  可以自己创建一个实现此接口的类，编写具体逻辑，然后new一个对象放到这
                 *  也可以本类自己实现此接口，这里写上this，类里再覆写一个invoke方法
                 *  也可以直接在这写匿名内部类，本例采用此法
                 */
                //创建一个匿名内部类, InvocationHandler是一个接口, 里面只有一个方法, 将其覆写
                new InvocationHandler() {
                    /*
                     * 有三个方法:
                     * proxy - 在其上调用方法的代理实例, 注意invoke有点类似反射的调用, 相当于反向来调用proxy的方法
                     * method - 对应于在代理实例上调用的接口方法的 Method 实例。Method 对象的声明类将是在其中声明方法的接口，该接口可以是代理类赖以继承方法的代理接口的超接口。
                     * args - 包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为 null。基本类型的参数被包装在适当基本包装器类
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 所以代理类方便，不用去重写每个被代理类的方法
                        System.out.println("目标方法前的逻辑");

                        /*
                            ...之前的代码
                         */

                        // 利用反射, 执行目标对象的方法, 并接收返回值
                        Object reInvoke = method.invoke(new Target(), args);

                        /*
                            ...之后的代码
                         */

                        System.out.println("目标方法后的逻辑");


                        // 可以将返回值直接返回, 也可以处理后再返回.
                        return reInvoke;
                    }
                }); //创建代理对象完毕

        /*
            因为目标对象实现了接口T, 代理对象也实现了接口T,
            那么就可以像使用目标对象一样来使用代理对象, 只是代理对象的功能更丰富了.
         */
        //调用方法1
        targetProxy.method1();
        //调用方法2 有返回值的情形
        System.out.println(targetProxy.method2());
        //调用方法3 有返回值有参数的情形
        System.out.println("method3的返回值: " + targetProxy.method3(520));

    }
}
