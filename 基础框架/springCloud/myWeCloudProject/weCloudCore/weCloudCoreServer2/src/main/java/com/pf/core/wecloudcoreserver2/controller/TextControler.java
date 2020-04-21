package com.pf.core.wecloudcoreserver2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextControler {

    @RequestMapping("/cloudText")
    @ResponseBody
    public String cloudText(){
        return "测试成功!";
    }
}

