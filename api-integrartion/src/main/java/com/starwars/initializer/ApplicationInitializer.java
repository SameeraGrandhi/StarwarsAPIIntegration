package com.starwars.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.starwars")
public class ApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApplicationInitializer.class);
        app.run(args);
    }
}
