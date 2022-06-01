package com.entelgy.reto01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ComponentScan(basePackages = "com.entelgy.reto01")
@ComponentScan
@ImportResource("classpath:app-config.xml")
public class Reto01Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto01Application.class, args);
	}

}
