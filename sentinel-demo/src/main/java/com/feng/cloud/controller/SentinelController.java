package com.feng.cloud.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description://流控  设置在服务提供方
 * @Author: fangx
 * @Data 2024年06月23日 21:44
 */
@RestController
@Slf4j
public class SentinelController {

    private static final  String RESOURCE_NAME = "hello";

    private static final  String USER_RESOURCE_NAME = "user";

    @RequestMapping(value = "/hello")
    public String hello(){
        Entry entry = null;
        try{
            // sentinel针对资源进行限制的
            entry = SphU.entry(RESOURCE_NAME);
            // 被保护的业务逻辑
            String str = "你好";
            log.info(str);
            return str;
        } catch (BlockException e) {
            // 资源阻止访问，被限流或者降级
            log.info("block");
            return "被流控了";
        }catch (Exception e){
            // 若需要配置降级规则，通过这种方式记录异常
            Tracer.traceEntry(e,entry);
        }finally {
            if(entry != null){
                entry.exit();
            }
        }
        return null;
    }

    /**
     * spring初始化方法
     */
    @PostConstruct
    private static void initFlowRules(){

        //流控规则
        List<FlowRule> ruleList = new ArrayList<>();

        // 流控
        FlowRule rule = new FlowRule();

        //设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        //设置流控规则 qps(每秒的访问数)
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 阈值 表示每秒只能访问一次
        rule.setCount(1);
        ruleList.add(rule);

        FlowRule rule2 = new FlowRule();

        //设置受保护的资源
        rule2.setResource(USER_RESOURCE_NAME);
        //设置流控规则 qps(每秒的访问数)
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 阈值 表示每秒只能访问一次
        rule2.setCount(1);
        ruleList.add(rule2);
        // 加载
        FlowRuleManager.loadRules(ruleList);
    }

    /**
     * @SentinelResource改善接口中定义和被流控降级后的处理方法
     * value资源定义
     * blockHandler 设置流控降级的处理方法 （优先级高于falllback的处理方法）
     * falllback 当借口出现了异常，交给fallback方法进行处理
     * @return
     */
    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME,
            blockHandler = "blockHandlerForGetUser")
    public String getUser(String id){
        return "111";
    }

    /**
     * 一定要public
     * 返回值一定要和源方法一致，包含原方法的惨胡
     * 参数添加BlockException是为了区分是什么样的异常
     * @param e
     * @return
     */
    public String blockHandlerForGetUser(String id,BlockException e){
        log.info("222222");
        e.printStackTrace();
        return "222";
    }
}
