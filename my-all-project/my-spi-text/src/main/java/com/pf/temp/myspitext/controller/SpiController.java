package com.pf.temp.myspitext.controller;

import com.pf.temp.myspitext.service.HelloInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ServiceLoader;

@Controller
public class SpiController {

    @RequestMapping("/textSpi")
    @ResponseBody
    public void textSpi(){
        ServiceLoader<HelloInterface> serviceLoader = ServiceLoader.load(HelloInterface.class);
        for (HelloInterface hello: serviceLoader) {
            hello.sayHello();
        }
    }
}
