package com.feng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年06月05日 21:55
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerOpenFigenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOpenFigenApplication.class,args);
    }


}
