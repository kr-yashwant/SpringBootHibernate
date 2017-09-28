package com.springBootHib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.springBootHib"})
public class SpringBootHibApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibApplication.class, args);
	}
}
