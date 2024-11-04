package com.yalovauni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.yalovauni")
public class YalovauniApplication {

    public static void main(String[] args) {
        SpringApplication.run(YalovauniApplication.class, args);
    }

}
