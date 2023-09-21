package com.human.jeungsangdiary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.human.jeungsangdiary.board.controller.storage.StorageProperties;
import com.human.jeungsangdiary.board.controller.storage.StorageService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableConfigurationProperties(StorageProperties.class)
public class JeungsangdiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeungsangdiaryApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
