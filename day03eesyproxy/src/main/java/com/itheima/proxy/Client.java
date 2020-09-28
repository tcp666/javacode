package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
      final Producer producer=new Producer();

        /**
         * 动态代理；
         * 特点：字节码随用随创建，随用随加载
         *      不改源码的基础上对方法增强
         * 分类：
         *  基于接口：
         *      涉及的类：Proxy
         *      jdk:官方
         *      创建：
         *      Proxy的newProxyInstance方法
         *
         *           Proxy.newProxyInstance("")的参数
         *          ClassLoader:类加载器
         *              用于加载代理对象字节码的，写的是被代理对象的字节码
         *              producer.getClass().getClassLoader()
         *          Class[]:用于让代理对象和被代理对象有相同方法
         *
         *          InvocationHandler:
         *          用于提供增强的代码，写如何代理，通常写匿名内部类
         *          此接口的实现类谁用谁写
        *  基于子类：
         */


      IProducer proxyProducer= (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {

          /**
           *作用：用于执行代理对象的任何接口方法都会经过该方法、
           * 方法参数的含义
           * @param proxy 代理对象的引用
           * @param method 当前执行的方法
           * @param args  当前执行方法的参数
           * @return     和被代理对象方法有相同的返回值
           * @throws Throwable
           */

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               Object returnValue=null;
                Float money=(Float)args[0];
                if ("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                }

                return returnValue;

            }
        });

      proxyProducer.saleProduct(10000f);
    }
}
