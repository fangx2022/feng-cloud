package com.feng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年06月05日 21:55
 */
@SpringBootApplication
public class Cloud1Application {

    public static void main(String[] args) {
        SpringApplication.run(Cloud1Application.class,args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate build = builder.build();
        return build;
    }
}
