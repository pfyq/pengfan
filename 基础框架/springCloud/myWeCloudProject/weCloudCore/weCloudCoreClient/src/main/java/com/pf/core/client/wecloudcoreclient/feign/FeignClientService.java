package com.pf.core.client.wecloudcoreclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户端调用
 * 页面上无法调用
 * 基于Feign使用Hystrix(注意)
 * 错误回调需要启动熔断器
 */
@FeignClient(value = "nacos-discovery-server",fallback = FeignClientHystrix.class)
public interface FeignClientService {

    @RequestMapping(value="/getMessage")
    String getMessage();

}
