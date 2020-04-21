package com.pf.core.corezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CorezuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorezuulApplication.class, args);
    }

}
