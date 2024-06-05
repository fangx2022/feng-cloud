package com.feng.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: //TODO
 * @Author:fangx
 * @Date:2024/6/5 11:45
 */
@RestController
@RequestMapping("/cloud1")
public class Cloud1Controller {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public String addCloud1(){
        System.out.println("cloud1 添加成功!!!");
        restTemplate.getForObject("http://localhost:8082/cloud2/add",String.class);
        return "cloud1 add success";
    };
}
