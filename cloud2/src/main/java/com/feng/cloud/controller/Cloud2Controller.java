package com.feng.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: //TODO
 * @Author:fangx
 * @Date:2024/6/5 11:45
 */
@RestController
@RequestMapping("/cloud2")
public class Cloud2Controller {
    @RequestMapping("/add")
    public String addCloud2(){
        System.out.println("cloud2 添加成功!!!");
        return "cloud2 add success";
    };

}
