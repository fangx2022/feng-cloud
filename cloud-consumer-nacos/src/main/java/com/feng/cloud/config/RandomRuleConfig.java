package com.feng.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author fangx
 * @Date 2024/6/11 18:20
 * @Description 自定义实现Ribbon负载均衡demo
 */
public class RandomRuleConfig extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        // 获取当前请求服务的实例
        List<Server> reachableServers = loadBalancer.getReachableServers();
        int random = ThreadLocalRandom.current().nextInt(reachableServers.size());
        Server server = reachableServers.get(random);
        return server;
    }
}
