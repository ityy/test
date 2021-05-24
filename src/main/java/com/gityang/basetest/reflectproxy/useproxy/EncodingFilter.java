package cn.yang.basetest.reflectproxy.useproxy;


import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 创建自定义过滤器
 * 在过滤器里应用动态代理 将request进行增强 经过判断只对其获取参数的方法单独增强, 使其编码后再返回.
 * 创建过滤器，并在web.xml中注册，拦截全部（即/*）
 * @author Yang
 *
 */
public class EncodingFilter implements Filter{


    /**
     * 拦截后执行
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //万年不变的开头强转
        final HttpServletRequest req = (HttpServletRequest) request;


        //使用动态代理完成全局编码
        HttpServletRequest enhanceRequset = (HttpServletRequest) Proxy.newProxyInstance(
                req.getClass().getClassLoader(),
                req.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        String name = method.getName();//获得目标对象的方法名称
                        //getParameter方法拦截并增强
                        if("getParameter".equals(name)){
                            String invoke = (String) method.invoke(req, args);//乱码
                            //处理转码，不管get还是post都能用
                            invoke = new String(invoke.getBytes("iso8859-1"),"UTF-8");
                            return invoke;
                        }
                        //其他方法直接放行
                        return method.invoke(req, args);
                    }
                }

        );

        //放行 并用代理类替换掉原本的类，实现动态拦截
        chain.doFilter(enhanceRequset, response);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}