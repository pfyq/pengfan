package com.pf.core.cloudnacosconfig.listener;


import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.YamlJsonParser;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoggingSystemConfigListener {


    private static final String LOGGER_TAG = "logging.level.";

    @Autowired
    private LoggingSystem loggingSystem;

    //貌似没用后面再研究
    @NacosConfigListener(dataId = "${config.data-id}", type = ConfigType.YAML, timeout = 5000)
    public void onChange(String newLog) throws Exception {
        Map<String, Object> map = new YamlJsonParser().parseMap(newLog);
        for (Object t : map.keySet()) {
            String key = String.valueOf(t);
            // 如果是 logging.level 配置项，则设置其对应的日志级别
            if (key.startsWith(LOGGER_TAG)) {
                Object val = map.get(key);
                String strLevel = val!=null&&val.toString()!=""?val.toString():"info";
                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
                loggingSystem.setLogLevel(key.replace(LOGGER_TAG, ""), level);
            }
        }
    }
}
