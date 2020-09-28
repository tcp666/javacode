package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *和spring连接数据相关的配置类
 *一般情况下要写，也可以传ClassName.class
// */
//@Configuration
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    /**
     * 用于创建QueryRunner
     *
     * @param dataSource
     * @return new QueryRunner(dataSource);
     */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner creatQueryRunner(@Qualifier("ds2") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
    @Bean(name="ds2")
    public DataSource createDataSource() {

        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;

        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

    }
    @Bean(name="ds1")
    public DataSource createDataSource1() {

        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/ftf_db?serverTimezone=UTC");
            ds.setUser(username);
            ds.setPassword(password);
            return ds;

        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

    }
}
