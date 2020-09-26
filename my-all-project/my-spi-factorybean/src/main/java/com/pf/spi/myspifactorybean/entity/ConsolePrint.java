package com.pf.spi.myspifactorybean.entity;

import com.pf.spi.myspifactorybean.dao.IPrint;
import org.springframework.stereotype.Component;

@Component
public class ConsolePrint implements IPrint {

    @Override
    public void print(String msg) {
        System.out.println("console print: " + msg);
    }

    @Override
    public boolean verify(Integer condition) {
        return condition <= 0;
    }
}
