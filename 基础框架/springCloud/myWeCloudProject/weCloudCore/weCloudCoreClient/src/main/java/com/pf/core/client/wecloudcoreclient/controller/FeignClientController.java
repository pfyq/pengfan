package com.pf.core.client.wecloudcoreclient.controller;

import com.pf.core.client.wecloudcoreclient.feign.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {

    @Autowired
    private FeignClientService feignClientService;

    @RequestMapping("/getMessage")
    public String call() {
        // 像调用本地服务一样
        return feignClientService.getMessage();
    }
}
