package config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置类相当于bean.xml
 * spring中新注解
 * Configuration:
 * 作用，指定当前类是一个配置类
 * 当配置类作为AnnotationConfigApplicationContext(SpringConfiguration.class)的参数时可以不写
 * ComponentScan
 * 用于通过注解指定Spring在创建容器时需要扫描的包
 * value：basePackages的作用时一样的
 * 等同于在xml中配置了context:component-scan base-package="com.itheima"></context:component-scan>
 *
 * @bean 作用，用于把当前方法的返回值存入springioc的容器中
 * 注解的属性：
 * name:指定bean的id,不写时是当前方法的名
 * 方法有参数spring会在容器中查找有没有可用的，和Autowrite一样的
 *@Import:
 * 作用：用于导入其他配置类
 * 属性：
 *  value:用于指定 其他配置类的字节码
 *  使用Import之后，有Import注解的类就是主配置类，导入的式子配置类
 * @PropertiesSource
 *  用于指定propertise文件路的名称和路径
 *  classpath:表示类路径
 */
//@Configuration
@ComponentScan("com.itheima")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {



}
