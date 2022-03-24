package com.beloved;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.beloved.mapper")
@SpringBootApplication
public class SpringSecurity01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity01Application.class, args);
    }

}
