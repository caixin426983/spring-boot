package com.cx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.cx.modules.admin")
@ServletComponentScan(basePackages = "com.cx.config")
@EnableSwagger2
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
