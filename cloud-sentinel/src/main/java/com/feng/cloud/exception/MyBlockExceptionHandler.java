package com.feng.cloud.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.cloud.domain.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年07月14日 23:17
 */
@Component
@Slf4j
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    //Logger log = LoggerFactory.getLogger(this.getClass()); 等同于@Slf4j
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        // 打印资源 规则的详细信息
        log.info("BlockException-----"+e.getRule());
        ResponseDTO responseDTO = null;
        if(e instanceof FlowException){
            responseDTO = ResponseDTO.error(100,"接口被限流了");
        }else if(e instanceof DegradeException){
            responseDTO = ResponseDTO.error(101,"服务降级了");
        }else if(e instanceof ParamFlowException){
            responseDTO = ResponseDTO.error(102,"热点参数限流了");
        }else if(e instanceof SystemBlockException){
            responseDTO = ResponseDTO.error(103,"触发系统保护规则了");
        }else if(e instanceof AuthorityException){
            responseDTO = ResponseDTO.error(104,"授权规则不通过");
        }
        //
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(),responseDTO);
    }
}
