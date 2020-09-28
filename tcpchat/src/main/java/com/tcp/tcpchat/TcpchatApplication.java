package com.tcp.tcpchat;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.tcp.tcpchat.mapper","com.tcp.tcpchat.entity"})
public class TcpchatApplication {
    public static void main(String[] args) {
        SpringApplication.run(TcpchatApplication.class, args);
    }

}
