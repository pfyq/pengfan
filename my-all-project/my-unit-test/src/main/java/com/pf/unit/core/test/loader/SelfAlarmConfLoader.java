package com.pf.unit.core.test.loader;




import com.pf.unit.core.entity.AlarmConfig;
import com.pf.unit.core.execut.SimpleExecuteFactory;
import com.pf.unit.core.loader.api.IConfLoader;
import com.pf.unit.core.loader.entity.RegisterInfo;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yihui on 2018/2/6.
 */
public class SelfAlarmConfLoader implements IConfLoader {
    @Override
    public RegisterInfo getRegisterInfo() {
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setMaxAlarmType(100);
        registerInfo.setDefaultAlarmUsers("yihui");
        registerInfo.setAppName("protoServer");
        return registerInfo;
    }

    @Override
    public boolean alarmEnable(String alarmKey) {
        return true;
    }

    @Override
    public boolean containAlarmConfig(String alarmKey) {
        return true;
    }

    @Override
    public AlarmConfig getAlarmConfigOrDefault(String alarmKey) {
        //db 查询，获取对应的配置信息
        // 下面是模拟，返回一个固定的配置
        AlarmConfig alarmConfig = new AlarmConfig();
        alarmConfig.setExecutor(SimpleExecuteFactory.getExecute("WEIXIN"));
        alarmConfig.setAutoIncEmergency(false);
        alarmConfig.setMinLimit(10);
        alarmConfig.setMaxLimit(14);
        alarmConfig.setUsers(Arrays.asList("yihui"));
        alarmConfig.setAlarmThreshold(Collections.emptyList());
        return alarmConfig;
    }

    @Override
    public int order() {
        return 20;
    }
}
