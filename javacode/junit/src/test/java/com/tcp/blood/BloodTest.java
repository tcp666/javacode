package com.tcp.blood;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

/**
 * BloodTest
 */
@RunWith(Parameterized.class)
public class BloodTest {

    private String result;
    private double emptyBloodSugar;
    private double workAfterBloodSugar;
    private Blood blood;

    /**
     * 参数化用例
     * @return
     */
    @Parameterized.Parameters
    public static Collection params(){
        return Arrays.asList(
                new Object[] {"糖耐量减低(IGT)",5.6,8.0},
                new Object[] {"数据异常",6.4,12.3},
                new Object[] {"空腹血糖受损( IFG)",6.4,7.6},
                new Object[] {"数据异常",7.5,7.6},
                new Object[] {"糖耐量减低(IGT)",6.4,8.2},
                new Object[] {"数据异常",6.4,12.2},
                new Object[] {"正常血糖( NGR)",5.6,7.2},
                new Object[] {"数据异常",7.3,7.3},
                new Object[] {"空腹血糖受损( IFG)",6.7,7.6},
                new Object[] {"数据异常",6.7,12.1},
                new Object[] {"数据异常",8.0,8.2},
                new Object[] {"糖耐量减低(IGT)",5.3,8.2},
                new Object[] {"数据异常",8.0,10.2},
                new Object[] {"数据异常",8.0,7.2},
                new Object[] {"数据异常",5.0,12.1},
                new Object[] {"数据异常",6.5,12.1}


        );
    }

    /**
     * 构建测试对象
     * @param result
     * @param emptyBloodSugar
     * @param workAfterBloodSugar
     */
    public BloodTest(String result,double emptyBloodSugar,double workAfterBloodSugar){
        this.result=result;
        this.emptyBloodSugar=emptyBloodSugar;
        this.workAfterBloodSugar=workAfterBloodSugar;
    }

    /**
     * 规格化测试
     */
    @Test
    public void test1(){
        blood=new Blood(emptyBloodSugar,workAfterBloodSugar);
        Assert.assertEquals(this.result, this.blood.getResult());
    }
}
