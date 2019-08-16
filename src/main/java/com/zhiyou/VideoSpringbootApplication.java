package com.zhiyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhiyou.dao")//自动扫描路径下所有接口
public class VideoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoSpringbootApplication.class, args);
		
		
		
	}

}
