package com.itheima.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean的工程
 * Bean:在计算机英语中可重用组件的含义（豆子的意思）
 * javaean:用java语言编写的重用组件
 * javabean  >>  实体类(远大于)
 * <p>
 * 它就是创建我们的service和dao对象的
 * 第一个：
 * 1，需要配置文件
 * 文件内容发：权限顶类型，标识（key=value）
 * 2，读取文件通过反射创建对象
 * <p>
 * 配置文件：
 * properties
 * xml
 */
public class BeanFactory {
    private static Properties props;

    //定一个容器
    private static Map<String, Object> beans;

    //使用静态代码块为负值
    static {
        try {
            //        实例化
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");
            props.load(in);
            beans = new HashMap<String, Object>();
           Enumeration<Object> kes= props.keys();
           while (kes.hasMoreElements()){
               String key=kes.nextElement().toString();
               String beabpath=props.getProperty(key);
               Object object=Class.forName(beabpath).newInstance();
               beans.put(key,object);
           }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化资源失败");
        }
    }

    /**
     * 根据类型获取值
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
    /**
    public static Object getBean(String beanName) {
        Object bean = null;
        try {

            String beanPath = props.getProperty(beanName);

            bean = Class.forName(beanPath).newInstance();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
    */
}
