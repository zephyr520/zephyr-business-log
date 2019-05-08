package com.zephyr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zephyr.core.dao")
public class BusinessLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessLogApplication.class, args);
	}
}
