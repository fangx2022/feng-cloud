package com.feng.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description://流控  设置在服务提供方
 * @Author: fangx
 * @Data 2024年06月23日 21:44
 */
@RestController
@Slf4j
@RequestMapping("sentinel")
public class SentinelController {

    @RequestMapping("/add")
    public String addCloud2(){
        return "cloud2 add success";
    };


    @RequestMapping("/flow")
//    @SentinelResource(value = "flow",blockHandler ="flowBlockHandler")
    public String flow(){
        return "正常访问";
    };

    public String flowBlockHandler(BlockException e){
        return "流控";
    };

    @RequestMapping("/flowThread")
    @SentinelResource(value = "flowThread",blockHandler ="flowBlockHandler")
    public String flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "正常访问";
    };


}
