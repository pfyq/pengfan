package com.pf.core.wecloudcoreserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WecloudcoreserverApplication {

    private static final Logger logger = LoggerFactory.getLogger(WecloudcoreserverApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WecloudcoreserverApplication.class, args);
        logger.info("nacos-discovery-server启动");
    }

    @GetMapping("getMessage")
    public String getMessage(){
        return "来调戏我啊！！！";
    }

}
