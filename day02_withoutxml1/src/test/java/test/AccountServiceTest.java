package test;


import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 单元测试
 * 当测试方法执行时没有IOC容器，即使写了Atu
 * Spring整合junit
 * 1，导入jar包
 * 2,使用junit提供的注解把原有的main方法替换了，替换成spring提供的
 * @Runwith
 * 3，告知运行器，springioc的创建基于下xml的还是注解的
 *  @ContextConfiguration()
 *      location:指定xml文件的位置加上classpath关键字，表示在类路径下
 *      classes:指定注解类梭子啊位置
 *      当我们使用spring 5.x的时候junit必须是4.12以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

  @Autowired
    private IAccountService as=null;



    @Test
    public void testfindAll() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");



        List<Account> accounts = as.findAllaccount();
        for (Account account : accounts)
            System.out.println(account);

    }

    @Test
    public void testfindOne() {
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        System.out.println(as.findAccountById(1));
    }

    @Test
    public void testSave() {
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setMoney(10000);
        account.setName("唐财平");
        as.saveAccount(account);
    }

    @Test
    public void testupdate() {
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setMoney(5000);
        account.setName("唐财平");
        account.setId(4);
        as.updateAccount(account);
    }

    @Test
    public void delete() {
//        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);

        as.deleteAccount(7);
        as.deleteAccount(8);
        as.deleteAccount(10);
    }
}
