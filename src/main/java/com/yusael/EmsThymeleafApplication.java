package com.yusael;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yusael.dao")
public class EmsThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsThymeleafApplication.class, args);
	}

}
