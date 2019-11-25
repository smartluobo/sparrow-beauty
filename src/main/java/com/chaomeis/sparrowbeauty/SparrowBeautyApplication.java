package com.chaomeis.sparrowbeauty;

import com.chaomeis.sparrowbeauty.filter.CrosFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = "com.chaomeis.sparrowbeauty.mapper")
public class SparrowBeautyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparrowBeautyApplication.class, args);
	}

}
