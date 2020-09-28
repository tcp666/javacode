package com.itheima.service.imp;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * <bean id="accountService"
 * class="com.itheima.service.imp.AccountServiceImp">
 *
 *
 * </bean>-->
 * 用于创建对象的：
 * 相当于bean标签的作用
 *
 * @Component: 用于把当前类对象存入Spring容器中
 * 属性：value:用于指定bean的id。当我们不写时是当强类名首字母小写
 * Controller：表现层
 * <p>
 * Service：服务层
 * Repository：一般用在持久层
 * <p>
 * <p>
 * <p>
 * <p>
 * 以上三个和Component一样的
 * 明确三层使用
 * 用于注入数据的
 * <p>
 * 相当于bean中写proprietary一样
 * Autowired:
     * 自动按照类型注入只要bean中
     * 位置：成员变量上
     * 也可以是方法上
     * 细节如果有一个和类型匹配就直接注入，有多个的话再用变量名去匹配，若果不能去确定就报错
 *      零个类型也报错
 *Qualifier:
 *  在按照类中注入的基础上再按照名注入，再给类成员注入时不能单独使用，但是再给方法参数注入时可以单独使用
 *  value用于注入指定bean的id
 *Resource:
 * 直接按照bean的id注入
 * 属性：name
 *不能适用于String
 *
 * 另外
 * Value:
 * value值，也可以使用springEl(el表达式)
 * ${表达式}
 * <p>
 * 用于改变作用范围的
 * bean中的scope一样
 * scope:
 *      指定作用范围：
 *
 * 和生命周期相关
 * PreDestroy:指定销毁方法销毁
 * PostConstruct:指定初始化方法
 * bean中的init-method和destroy-method
 */
@Component("accountService")
//@Scope("prototype")
public class AccountServiceImp implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao1")
    private IAccountDao accountDao=null;

    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init(){
        System.out.println("init...........");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroied....");
    }
}
