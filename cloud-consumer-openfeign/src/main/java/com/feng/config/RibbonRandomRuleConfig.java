package com.feng.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author fangx
 * @Date 2024/6/11 15:31
 * @Description //TODO
 */
@Configuration
public class RibbonRandomRuleConfig {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
