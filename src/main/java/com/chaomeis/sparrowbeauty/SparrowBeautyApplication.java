package com.chaomeis.sparrowbeauty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chaomeis.sparrowbeauty.mapper")
public class SparrowBeautyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparrowBeautyApplication.class, args);
	}

}
