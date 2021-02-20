package com.nvxclouds.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Auther: zhengxing.hu
 * @Date: 2020/3/23 16:20
 * @Description: 全局前置过滤器
 */
@Slf4j
@Component
public class Filter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入前置过滤器");
        log.info("请求前的URL:{}",exchange.getRequest().getURI().toString());
        //权限检查


        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    log.info("后置调用");
                    log.info("请求后的URL:{}",exchange.getRequest().getURI().toString());
                })

        );
    }

    /**
     * 过滤级别
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }


}
