package com.feng.cloud.controller;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.feng.cloud.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description://降级熔断   设置在服务消费方
 * @Author: fangx
 * @Data 2024年06月25日 21:52
 */
@RestController
public class SentinelDegradeController {


    @RequestMapping("/degrade")
    @SentinelResource(value = "degrade",entryType = EntryType.IN, blockHandler = "mytest")
    public User degrade() throws InterruptedException{
        throw new RuntimeException("异常");
    }

    public User mytest(BlockException e){
        return new User("降级熔断！");
    }

    @PostConstruct
    public void initDegradeRule(){
        List<DegradeRule> degradeRules = new ArrayList<>();
        //降级规则，异常
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("degrade");
        //设置规则侧率 异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //出发熔断异常数 2
        degradeRule.setCount(2);
        //触发熔断最小请求数 2
        degradeRule.setMinRequestAmount(2);
        //时长内
        degradeRule.setStatIntervalMs(60*1000);
        // 一分钟内 执行了2次，出现了两次异常 就会触发熔断

        //熔断时长：单位：s
        //一旦触发了熔断，再次请求接口就会直接调用降级方法
        // 10秒后半开状态，回复接口调用，如果还是异常，再次熔断，不会根据设置再走
        degradeRule.setTimeWindow(10);

        degradeRules.add(degradeRule);

        DegradeRuleManager.loadRules(degradeRules);

    }




}
