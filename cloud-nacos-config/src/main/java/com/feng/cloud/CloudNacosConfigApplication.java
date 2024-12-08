package com.feng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author fangx
 * @Date 2024/6/13 15:38
 * @Description //TODO
 */
@SpringBootApplication
@EnableFeignClients
public class CloudNacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CloudNacosConfigApplication.class, args);
        String username = run.getEnvironment().getProperty("user.name");
        String id = run.getEnvironment().getProperty("user.id");
        System.err.println("username:" + username + "  userID:" + id);
    }
}
