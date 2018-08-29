package com.cx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cx.modules.admin")
@ServletComponentScan(basePackages = "com.cx.config")
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
