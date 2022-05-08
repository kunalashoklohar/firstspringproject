package com.spring.firstspringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import io.swagger.annotations.Info;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FirstspringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringprojectApplication.class, args);
	}

}
