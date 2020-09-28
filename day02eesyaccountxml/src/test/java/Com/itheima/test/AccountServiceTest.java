package Com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.util.List;

/**
 *单元测试
 */
public class AccountServiceTest {
    @Test
    public void testfindAll() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as= ac.getBean("accountService",IAccountService.class);

        List<Account> accounts=as.findAllaccount();
        for (Account account:accounts)
            System.out.println(account);

    }
    @Test
    public void testfindOne() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as= ac.getBean("accountService",IAccountService.class);
        System.out.println(as.findAccountById(1));
    }
    @Test
    public void testSave() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as= ac.getBean("accountService",IAccountService.class);
Account account=new Account();
account.setMoney(10000);
account.setName("张海宁");
as.saveAccount(account);
    }
    @Test
    public void testupdate() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as= ac.getBean("accountService",IAccountService.class);
        Account account=new Account();
        account.setMoney(5000);
        account.setName("张海宁");
        account.setId(4);
      as.updateAccount(account);
    }
    @Test
    public void delete() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as= ac.getBean("accountService",IAccountService.class);
       as.deleteAccount(4);

    }
}
