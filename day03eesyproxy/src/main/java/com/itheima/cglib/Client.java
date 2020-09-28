package com.itheima.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;


public class Client {
    public static void main(String[] args) {
       final Producer producer=new Producer();

        /**
         * 动态代理；
         * 特点：字节码随用随创建，随用随加载
         *      不改源码的基础上对方法增强
         * 分类：
         *  基于子类：
         *      涉及的类：Enhancer
         *      jdk:第三方
         *      创建：
         *      Enhancer的create方法
         *      被代理类不能是最终类：
         *
         *         create()
         *          Class:字节码，被代理对象的字节码
         *
         *          Callback；用于提供增强代理
         *          一般写的都是该接口的子接口实现类：
         *          new MethodInterceptor()
         *
         *
         *
         * 基于子类：
         */

   Producer   cglibProducer= (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
              * @param o
             * @param method
             * @param objects
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue=null;
                Float money=(Float)objects[0];
                if ("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
   cglibProducer.saleProduct(10000f);
    }
}
