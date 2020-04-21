package com.pf.core.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Value("${consumer.hello}")
    private String hello;

    @Value("${consumer.myconfig}")
    private String myconfig;

    @RequestMapping("/hello")
    public Map hello() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("hello", hello);
        map.put("myconfig", myconfig);
        return map;
    }

}
