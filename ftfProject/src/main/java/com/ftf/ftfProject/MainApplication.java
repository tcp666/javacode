package com.ftf.ftfProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ftf.ftfProject.*")
public class MainApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}

}
