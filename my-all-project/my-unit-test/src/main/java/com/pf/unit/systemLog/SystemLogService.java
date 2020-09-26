package com.pf.unit.systemLog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class SystemLogService {

    @SystemLog
    public String log(String name) throws InterruptedException {
        log.info("执行业务方法");
        TimeUnit.SECONDS.sleep(1);
        return "hello " + name;
    }
}
