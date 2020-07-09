package com.resliv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class ReslivApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(ReslivApplication.class, args);
    }
}
