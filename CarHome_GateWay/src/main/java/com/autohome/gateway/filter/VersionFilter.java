package com.autohome.gateway.filter;

import com.autohome.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-30 12:01
 */
@Component
@Slf4j
public class VersionFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("过滤器----->");

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        //设置状态响应码 和 响应格式
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        //response.getHeaders().add("Content-Type", "text/html;charset=UTF-8");

        if (request.getQueryParams().containsKey("version")) {
            //验证版本号
            double v = Double.parseDouble(request.getQueryParams().get("version").get(0));
            log.info("过滤器----->版本号：" + v);
            if (v == 1.0) {
                // 放行
                return chain.filter(exchange);
            } else {
                //当前版本不支持
                DataBuffer dataBuffer = response.bufferFactory().wrap(new JSONObject(R.fail("当前版本不支持，请尽快升级")).toString().getBytes());
                // 返回响应信息
                return response.writeWith(Mono.just(dataBuffer));
            }
        } else {
            // 响应信息
            // DataBuffer dataBuffer = response.bufferFactory().wrap(
            //         new JSONObject(R.fail("当请传递版本号，version")).toString().getBytes());
            // return response.writeWith(Mono.just(dataBuffer));
            // 放行
            return chain.filter(exchange);
        }
    }

    /**
     * 过滤器执行顺序 数值越小，优先级越高
     */
    @Override
    public int getOrder() {
        return 1;
    }
}
