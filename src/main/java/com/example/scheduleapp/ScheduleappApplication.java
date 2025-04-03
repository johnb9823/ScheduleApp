package com.example.scheduleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScheduleappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleappApplication.class, args);
    }

}
