package com.godlikehzj.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DemoHandler implements InvocationHandler{
    private ProxyDemo proxyDemo;

    public DemoHandler(ProxyDemo proxyDemo) {
        System.out.println("init !!!!!");
        this.proxyDemo = proxyDemo;
    }

    public ProxyDemo getProxyInstance() {

        return (ProxyDemo) Proxy.newProxyInstance(proxyDemo.getClass().getClassLoader(), proxyDemo.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        //当设置断点时，该方法会重复执行一次
        //因为动态代理类会实现Object的toString，equals和hashCode，debug的时候查看对应类会默认执行toString方法，所有该类默认执行一次
        System.out.println("begin---------->>");

        Object o = null;
        try {
            System.out.println(method.getName());
             o = method.invoke(proxyDemo, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("end-------------->>");
        return o;
    }

    public static void main(String[] args) {

        DemoHandler p2 = new DemoHandler(new ProxyDemoImpl());
        ProxyDemo proxyDemo = p2.getProxyInstance();
        proxyDemo.demoTest("this is test");
        //动态代理源码最终调用以下方法生产代理类，通过defineClass0成功代理类实例，具体可参考反编译的代理类
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", proxyDemo.getClass().getInterfaces());
        String path = "/Users/godlikehzj/Documents/java/godlikehzj/common/src/main/java/com/godlikehzj/proxy/demo.class";
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
