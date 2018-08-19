package com.fme.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.fme.controller","com.fme.dao","com.fme.dao.impl"  })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
