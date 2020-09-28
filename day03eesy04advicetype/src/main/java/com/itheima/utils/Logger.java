package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类吗提供公共代码
 */
public class Logger {
    /**
     * 用于打印日志：计划让其在切入点方法执行前（业务层方法）
     */
    /**
     * 前置通知
     */
    public void beforPrintLog(){
        System.out.println("logger类中的前置通知beforPrintLog方法开始记录日志了");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("logger类中的后置通知afterReturningPrintLog方法开始记录日志了");
    }
    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("logger类中的异常通知afterThrowingPrintLog方法开始记录日志了");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("logger类中的异常通知afterPrintLog方法开始记录日志了");
    }

    /**
     * 环绕通知:
     *      问题：
     *          当我们配置了环绕通知后，切入点方法没有执行，而通知方法执行了
     *
     *原因；
     *  通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知有明确的切入点调用
     *  而我们的代码中没有
     *解决：
     * 调用一下就可以了
     * Spring框架为我们提供了一个接口：ProceedingjoinPoint.该接口有一个方法proceed(),此方法相当于明确调用切入点方法
     * 该接口可以作为环绕通知的方法参数，在执行式，spring框架会为我们提供该接口的实现类供我们使用
     *
     *spring环绕通知:
     * 它是spring框架为我们提供的一种可以在代码中手动增强方法何时执行的方式。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp)  {
      Object rtvalue=null;
        try {
            Object[] args=pjp.getArgs();
            System.out.println("qian类中的异常通知aroundPrintLog方法开始记录日志了");
          rtvalue=   pjp.proceed(args);//明确调用业务层方法
            System.out.println("hou类中的异常通知aroundPrintLog方法开始记录日志了");
            return rtvalue;
        } catch (Throwable throwable) {
            System.out.println("Exception:logger类中的异常通知aroundPrintLog方法开始记录日志了");
            throw new RuntimeException(throwable);
        }
        finally {
            System.out.println("finally:logger类中的异常通知aroundPrintLog方法开始记录日志了");
        }


    }
}
