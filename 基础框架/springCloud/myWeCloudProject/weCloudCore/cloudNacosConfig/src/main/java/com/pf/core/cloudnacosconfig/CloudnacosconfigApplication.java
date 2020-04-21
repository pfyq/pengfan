package com.pf.core.cloudnacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudnacosconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudnacosconfigApplication.class, args);
    }

}
