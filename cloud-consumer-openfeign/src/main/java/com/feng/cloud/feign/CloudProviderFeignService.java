package com.feng.cloud.feign;

import com.feng.cloud.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年06月12日 22:50
 *
 *
 */
//configuration表示已经添加了日志配置，配置类方式
@FeignClient(name="cloud-provider-service",path = "/cloud-provider",configuration = FeignConfig.class)
public interface CloudProviderFeignService {

    @RequestMapping("/add")
    public String addCloud2();
}
