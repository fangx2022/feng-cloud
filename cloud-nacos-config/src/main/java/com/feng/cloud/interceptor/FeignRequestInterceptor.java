package com.feng.cloud.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description://自定义feign拦截器
 * @Author: fangx
 * @Data 2024年06月12日 23:24
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截器设置
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //修改请求信息
        //requestTemplate.header()
        //requestTemplate.query();
        //requestTemplate.uri();
        logger.info("此处设置拦截器");
    }
}
