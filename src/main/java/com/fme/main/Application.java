package com.fme.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = { "com.fme.controller","com.fme.dao","com.fme.dao.impl","com.fme.dbo","com.fme.service" })
@EntityScan( basePackages = {"com.fme.dbo"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
    