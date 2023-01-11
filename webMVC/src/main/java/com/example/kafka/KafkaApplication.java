package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(KafkaApplication.class)
//        .web(WebApplicationType.NONE)
//        .run(args);
    		SpringApplication.run(KafkaApplication.class, args);
    }

}
