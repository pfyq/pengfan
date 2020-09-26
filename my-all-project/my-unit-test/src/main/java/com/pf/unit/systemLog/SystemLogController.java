package com.pf.unit.systemLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;

    @GetMapping("/log")
    public String hello(@RequestParam("name") String name) throws InterruptedException {
        return systemLogService.log(name);
    }
}
