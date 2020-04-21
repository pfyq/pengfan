package com.pf.core.wecloudcoreserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Wecloudcoreserver2Application {

    public static void main(String[] args) {
        SpringApplication.run(Wecloudcoreserver2Application.class, args);
    }


    @GetMapping("getMessage")
    public String getMessage(){
        return "来调戏我啊！！！    2";
    }
}
