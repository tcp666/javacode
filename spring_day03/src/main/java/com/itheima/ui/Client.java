package com.itheima.ui;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 获取核心容器
 * ApplicationContext的三个常用实现类
 * ClassPathXmlApplicationContext
 * 加载类路径下的配置文件,要求配置文件必须在类路径下
 * 不在的话加载不赖哦
 * ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
 * FileSystemXmlApplicationContext
 * <p>
 * 可以加载磁盘任意路经下的配置文件，要求有访问权限
 * ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\SpringDemos\\spring_day03\\src\\main\\resources\\bean.xml");
 * AnnotationConfigApplicationContext
 * 用于读取注解创建容器
 */
public class Client {

    /**
     * ApplicationContext：采用此接口比较多
     *  构建核心容时立即加载的方式，读取完马上就会创建配置文件中的对象
     *  单例对象适用
     * BeanFactory:
     * 构建核心容器时延迟加载，什么时候根据id获取对象了，什么时候才创建
     * 多例对象适用
     * @param args
     */
    public static void main(String[] args) {

   /**
    *  //1，获取核心容器
        // ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\SpringDemos\\spring_day03\\src\\main\\resources\\bean.xml");
        //获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao ad = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(ad);
        as.saveAccount();
        return;
*/

        BeanFactory factory=null;
        Resource resource=null;
        resource=new ClassPathResource("bean.xml");
        factory=new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");
        IAccountDao ad = factory.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(ad);
    }

}
