package com.jfeat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class AmApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmApplication.class, args);
        log.info("Application run success!");
    }
}