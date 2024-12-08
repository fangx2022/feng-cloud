package com.feng.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年06月12日 22:54
 *
 *
 * feign日志两种方式  全局配置1.使用@Configuration 会将配置作用到所有的服务提供方
 *                  局部配置1.配置类
 *                         2.配置文件
 */
//@Configuration
public class FeignConfig {

    /**
     * 日志级别设置  注解方式看配置文件
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 超时时间设置  配置类方式   注解方式看配置文件
     */
//    @Bean
//    public Request.Options options(){
//        return new Request.Options(5000,10000);
//    }

    /**
     * feign拦截器 配置类方式   注解方式看配置文件
     * @return
     */
//    @Bean
//    public FeignRequestInterceptor feignRequestInterceptor(){
//        return new FeignRequestInterceptor();
//    }

}
