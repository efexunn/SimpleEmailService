package com.efexunn.simplemailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimpleMailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleMailSenderApplication.class, args);
    }

}
