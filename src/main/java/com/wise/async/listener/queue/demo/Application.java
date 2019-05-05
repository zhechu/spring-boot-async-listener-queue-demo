package com.wise.async.listener.queue.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @SpringBootApplication 注解等价于以默认属性使用 @Configuration， @EnableAutoConfiguration 和 @ComponentScan
 * @author lingyuwang
 *
 */
@SpringBootApplication(scanBasePackages = "com.wise")
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
