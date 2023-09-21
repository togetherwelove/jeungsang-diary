package com.human.jeungsangdiary;

import com.human.jeungsangdiary.board.controller.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(StorageProperties.class)
public class JeungsangdiaryApplication {

  public static void main(String[] args) {
    SpringApplication.run(JeungsangdiaryApplication.class, args);
  }
}
