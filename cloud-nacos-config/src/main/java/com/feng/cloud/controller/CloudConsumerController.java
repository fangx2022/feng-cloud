package com.feng.cloud.controller;

import com.feng.cloud.feign.CloudProviderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: //TODO
 * @Author:fangx
 * @Date:2024/6/5 11:45
 */
@RestController
@RequestMapping("/cloud-consumer-openfeign")
public class CloudConsumerController {

    @Autowired
    private CloudProviderFeignService cloudProviderFeignService;

    @RequestMapping("/add")
    public String addCloud1(){
        System.out.println("cloud1 添加成功!!!");
        String message = cloudProviderFeignService.addCloud2();
        return "cloud1 add success  "+message;
    };
}
