package com.zhiyou.config;

import java.util.Properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

/**
 * 这是一个配置类
 */
@SpringBootConfiguration
public class MbatisPageHellpConfig {
	@Bean
	public PageHelper pageHelper() {
		PageHelper p=new PageHelper();
		//创建一个属性文件对象，把实例化PageHelper需要的参数写进去
		Properties per=new Properties();
		//设置页码
		per.setProperty("offsetAspageNum", "true");
		//分页的时候会进行count查询，总数
		per.setProperty("rowBoundsWithCount", "true");
		//分页参数合理化
		per.setProperty("reasonsable", "true");
		p.setProperties(per);
		return p;
	}
}
