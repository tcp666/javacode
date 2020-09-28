package test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试是否是单例类
 */
public class QueryRunnerTest {
    /**
     *
     */
    @Test
    public void testQueryRunner(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);

        QueryRunner runner1=ac.getBean("runner",QueryRunner.class);
        QueryRunner runner2=ac.getBean("runner",QueryRunner.class);
        QueryRunner runner3=ac.getBean("runner",QueryRunner.class);
        System.out.println(runner1==runner2);
        System.out.println(runner2);
        System.out.println(runner3);

    }

}
