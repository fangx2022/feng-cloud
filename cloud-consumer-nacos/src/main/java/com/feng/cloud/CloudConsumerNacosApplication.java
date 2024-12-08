package com.feng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年06月05日 21:55
 */
@SpringBootApplication
//@RibbonClients(value={
//        @RibbonClient(name="cloud-provider-service",configuration = RibbonRandomRuleConfig.class)
//})
public class CloudConsumerNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerNacosApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate build = builder.build();
        return build;
    }
}
