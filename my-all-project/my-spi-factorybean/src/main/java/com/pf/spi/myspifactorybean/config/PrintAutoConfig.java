package com.pf.spi.myspifactorybean.config;

import com.pf.spi.myspifactorybean.dao.IPrint;
import com.pf.spi.myspifactorybean.dao.SpiFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrintAutoConfig {

    @Bean
    public SpiFactoryBean printSpiPoxy(ApplicationContext applicationContext) {
        return new SpiFactoryBean(applicationContext, IPrint.class);
    }

    @Bean
    @Primary
    public IPrint printProxy(SpiFactoryBean spiFactoryBean) throws Exception {
        return (IPrint) spiFactoryBean.getObject();
    }
}
