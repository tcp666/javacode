package com.itheima.cglib;

import com.itheima.proxy.IProducer;

public class Producer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售铲平，拿到钱"+money);

    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后，并拿到钱"+money);
    }
}
