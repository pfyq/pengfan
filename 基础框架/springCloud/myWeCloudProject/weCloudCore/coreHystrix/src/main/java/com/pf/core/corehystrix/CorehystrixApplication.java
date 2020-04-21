package com.pf.core.corehystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * https://www.cnblogs.com/xifengxiaoma/p/9910326.html
 * 依次启动 monitor、producer、consumer，hystrix 服务，访问 http://localhost:8500  查看注册中心管理界面。
 * 确认服务无误之后， 访问 http://localhost:8501/hystrix，输入 http://localhost:8501/turbine.stream，查看监控图表。
 * */

@EnableTurbine//汇总系统内多个服务的数据并显示到Hystrix Dashboard上
@EnableHystrixDashboard//开启熔断监控   对Hystrix进行实时监控的工具
@SpringBootApplication
public class CorehystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorehystrixApplication.class, args);
    }
}
