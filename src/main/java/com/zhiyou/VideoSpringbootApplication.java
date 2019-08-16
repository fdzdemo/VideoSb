package com.zhiyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhiyou.dao")
public class VideoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoSpringbootApplication.class, args);
	}

}
