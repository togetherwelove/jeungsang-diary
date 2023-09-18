package com.human.jeungsangdiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JeungsangdiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeungsangdiaryApplication.class, args);
	}

}
