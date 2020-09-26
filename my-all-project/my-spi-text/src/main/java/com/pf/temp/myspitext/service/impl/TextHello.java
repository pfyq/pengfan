package com.pf.temp.myspitext.service.impl;

import com.pf.temp.myspitext.service.HelloInterface;

public class TextHello implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("text hello");
    }
}
