package com.atguigu.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class Springboot2AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2AmqpApplication.class, args);
    }

}
